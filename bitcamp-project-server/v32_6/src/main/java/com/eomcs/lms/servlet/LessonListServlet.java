package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonListServlet implements Servlet {
  List<Lesson> lessonList;

  public LessonListServlet(List<Lesson> lessonList) {
    this.lessonList = lessonList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.reset();
    out.writeObject(lessonList);
  }
}
