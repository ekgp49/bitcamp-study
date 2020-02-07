package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailServlet implements Servlet {
  List<Lesson> lessonList;

  public LessonDetailServlet(List<Lesson> lessonList) {
    this.lessonList = lessonList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    Lesson lesson = null;
    for (Lesson b : lessonList) {
      if (b.getNo() == no) {
        lesson = b;
      }
    }
    if (lesson == null) {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 수업정보가 없습니다.");
    } else {
      out.writeUTF("OK");
      out.writeObject(lesson);
    }
  }
}
