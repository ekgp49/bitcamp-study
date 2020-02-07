package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonAddServlet implements Servlet {
  List<Lesson> lessonList;

  public LessonAddServlet(List<Lesson> lessonList) {
    this.lessonList = lessonList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      Lesson lesson = (Lesson) in.readObject();
      lessonList.add(lesson);
      System.out.println("수업정보를 저장했습니다.");
      out.writeUTF("OK");
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
