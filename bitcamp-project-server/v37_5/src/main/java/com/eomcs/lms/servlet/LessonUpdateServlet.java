package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {
  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    int no = Integer.parseInt(in.nextLine());
    Lesson old = lessonDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson lesson = new Lesson();
    lesson.setNo(old.getNo());
    out.printf("강의명(%s)? \n", old.getTitle());
    out.println("!{}!");
    out.flush();
    lesson.setTitle(in.nextLine());

    out.printf("내용(%s)? \n", old.getDescription());
    out.println("!{}!");
    out.flush();
    lesson.setDescription(in.nextLine());

    out.printf("강의 시작일(%s)? \n", old.getStartDate());
    out.println("!{}!");
    out.flush();
    lesson.setStartDate(Date.valueOf(in.nextLine()));

    out.printf("강의 종료일(%s)? \n", old.getEndDate());
    out.println("!{}!");
    out.flush();
    lesson.setEndDate(Date.valueOf(in.nextLine()));

    out.printf("총 강의시간(%d)? \n", old.getTotalHours());
    out.println("!{}!");
    out.flush();
    lesson.setTotalHours(Integer.parseInt(in.nextLine()));

    out.printf("일 강의시간(%d)? \n", old.getDayHours());
    out.println("!{}!");
    out.flush();
    lesson.setDayHours(Integer.parseInt(in.nextLine()));

    if (lesson.equals(old)) {
      out.println("수업정보 변경을 취소했습니다.");
      return;
    }

    if (lessonDao.update(lesson) > 0) {
      out.println("수업을 변경했습니다.");
    } else {
      out.println("변경 실패");
    }
  }
}
