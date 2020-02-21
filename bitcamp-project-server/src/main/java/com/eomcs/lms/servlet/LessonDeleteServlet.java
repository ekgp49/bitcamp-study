package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteServlet implements Servlet {
  LessonDao lessonDao;

  public LessonDeleteServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    int no = Integer.parseInt(in.nextLine());

    if (lessonDao.delete(no) > 0) {
      out.println("삭제했습니다.");
    } else {
      out.println("해당번호의 수업이 없습니다.");
    }
  }
}
