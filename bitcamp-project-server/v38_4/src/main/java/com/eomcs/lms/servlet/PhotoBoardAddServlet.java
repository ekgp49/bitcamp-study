package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.DataLoaderListener;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.Prompt;

public class PhotoBoardAddServlet implements Servlet {
  PhotoBoardDao photoBoardDao;
  LessonDao lessonDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao, LessonDao lessonDao,
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.lessonDao = lessonDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(Prompt.getString(in, out, "제목? "));
    int lessonNo = Prompt.getInt(in, out, "수업번호? ");

    Lesson lesson = lessonDao.findByNo(lessonNo);
    if (lesson == null) {
      out.println("수업번호가 유효하지 않습니다");
      return;
    }
    photoBoard.setLesson(lesson);

    DataLoaderListener.con.setAutoCommit(false);

    try {
      if (photoBoardDao.insert(photoBoard) == 0) {
        throw new Exception("사진 게시글 등록을 실패했습니다.");
      }
      // 정상적으로 등록되었다면 첨부파일을 입력받는다.
      List<PhotoFile> photoFiles = inputPhotoFiles(in, out);

      // ArrayList에 들어있는 photoFile 데이터를 lms_photo_file 테이블에 저장한다.
      for (PhotoFile p : photoFiles) {
        p.setBoardNo(photoBoard.getNo());
        photoFileDao.insert(p);
      }
      DataLoaderListener.con.commit();
      out.println("새 사진 게시글을 등록했습니다.");

    } catch (Exception e) {
      out.println(e.getMessage());
      DataLoaderListener.con.rollback();
    } finally {
      DataLoaderListener.con.setAutoCommit(true); // 예외가 뜨든 말든 실행되어야함(finally{} 안에.)
    }

  }


  private List<PhotoFile> inputPhotoFiles(Scanner in, PrintStream out) {
    out.println("최소 한개의 사진 파일을 등록해야 합니다.");
    ArrayList<PhotoFile> photoFiles = new ArrayList<>();
    while (true) {
      String filepath = Prompt.getString(in, out, "사진 파일? ");
      if (filepath.length() == 0) {
        if (photoFiles.size() > 0) {
          break;
        } else {
          out.println("최소 한개의 사진 파일을 등록해야 합니다.");
          continue;
        }
      }

      // 기본생성자 써도 되는데 새로운 생성자를 정의해서 아래와 같이 쓸 수 있다.
      // 인스턴스 변수를 따로 안만들고 생성자 파라미터로 바로 값을 넣을 수 있어서 좋다.
      // photoFiles.add(new PhotoFile(filepath, photoBoard.getNo()));

      // setter 메서드(값을 set하고 인스턴스를 리턴하도록 함)를 활용하여
      // 체인방식으로 인스턴스 필드의 값을 설정. 디버깅할땐 안좋음.
      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }
    return photoFiles;
  }
}
