package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.Prompt;

public class PhotoBoardDetailServlet implements Servlet {
  PhotoBoardDao photoBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardDetailServlet(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;

  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    PhotoBoard photoBoard = photoBoardDao.findByNo(no);

    if (photoBoard != null) {
      out.printf("번호: %d\n", photoBoard.getNo());
      out.printf("제목: %s\n", photoBoard.getTitle());
      out.printf("등록일: %s\n", photoBoard.getCreatedDate());
      out.printf("조회수: %d\n", photoBoard.getViewCount());
      out.printf("수업번호: %d\n", photoBoard.getLesson().getNo());
      out.println("사진파일: ");

      for (PhotoFile photoFile : photoBoard.getFiles()) {
        out.printf("> %s\n", photoFile.getFilepath());
      }

    } else {
      out.println("해당번호의 사진 게시글이 없습니다.");
    }
  }
}
