package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateServlet implements Servlet {
  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");
    Lesson old = lessonDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson lesson = new Lesson();
    lesson.setNo(old.getNo());
    lesson.setTitle(Prompt.getString(in, out, String.format("강의명(%s)? ", old.getTitle())));

    lesson
        .setDescription(Prompt.getString(in, out, String.format("내용(%s)? ", old.getDescription())));

    lesson.setStartDate(Prompt.getDate(in, out, String.format("강의 시작일(%s)? ", old.getStartDate())));

    lesson.setEndDate(Prompt.getDate(in, out, String.format("강의 종료일(%s)? ", old.getEndDate())));

    lesson
        .setTotalHours(Prompt.getInt(in, out, String.format("총 강의시간(%d)? ", old.getTotalHours())));

    lesson.setDayHours(Prompt.getInt(in, out, String.format("일 강의시간(%d)? ", old.getDayHours())));


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
