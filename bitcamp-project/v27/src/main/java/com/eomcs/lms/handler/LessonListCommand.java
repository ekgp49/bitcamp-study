package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  List<Lesson> lessonList;

  public LessonListCommand(List<Lesson> list) {
    // List 파라미터는 List 인터페이스를 구현한 객체를 받는다.
    this.lessonList = list;
  }

  @Override
  public void execute() {
    Iterator<Lesson> list = lessonList.iterator();
    while (list.hasNext()) {
      Lesson l = list.next();
      System.out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getTitle(), l.getStartDate(),
          l.getEndDate(), l.getTotalHours());
    }
  }
}
