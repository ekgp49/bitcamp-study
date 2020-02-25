package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.DataLoaderListener;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.Prompt;

public class PhotoBoardUpdateServlet implements Servlet {
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardUpdateServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    PhotoBoard old = photoBoardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 사진 게시글이 없습니다.");
      return;
    }
    PhotoBoard photoBoard = new PhotoBoard();
    photoBoard.setTitle(
        Prompt.getString(in, out, String.format("제목(%s)? ", old.getTitle()), old.getTitle()));
    photoBoard.setNo(old.getNo());

    DataLoaderListener.con.setAutoCommit(false);

    try {
      if (photoBoardDao.update(photoBoard) == 0) {
        throw new Exception("사진 게시글 변경에 실패했습니다.");
      }
      printPhotoFiles(out, no);

      out.println();
      out.println("사진은 일부만 변경 할 수 없습니다.");
      out.println("전체를 새로 등록해야 합니다.");
      out.flush();

      String response = Prompt.getString(in, out, "사진을 변경하시겠습니까?(y/N)");
      if (response.equalsIgnoreCase("y")) {
        photoFileDao.deleteAll(no);

        List<PhotoFile> photoFiles = inputPhotoFiles(in, out);
        for (PhotoFile p : photoFiles) {
          p.setBoardNo(no);
          photoFileDao.insert(p);
        }
      }
      DataLoaderListener.con.commit();
      out.println("사진 게시글을 변경했습니다");
    } catch (Exception e) {
      out.println(e.getMessage());
      DataLoaderListener.con.rollback();
    } finally {
      DataLoaderListener.con.setAutoCommit(true);
    }
  }

  private void printPhotoFiles(PrintStream out, int no) throws Exception {
    out.println("사진 파일:");
    List<PhotoFile> oldPhotoFiles = photoFileDao.findAll(no);
    for (PhotoFile p : oldPhotoFiles) {
      out.printf("> %s\n", p.getFilepath());
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
      photoFiles.add(new PhotoFile().setFilepath(filepath));
    }
    return photoFiles;
  }
}
