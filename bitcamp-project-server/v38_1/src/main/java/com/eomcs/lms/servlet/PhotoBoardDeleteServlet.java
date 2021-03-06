package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;

public class PhotoBoardDeleteServlet implements Servlet {
  PhotoBoardDao photoBoardDao;

  public PhotoBoardDeleteServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    if (photoBoardDao.delete(no) > 0) {
      out.println("삭제했습니다.");
    } else {
      out.println("해당번호의 사진 게시물이 없습니다.");
    }
  }
}
