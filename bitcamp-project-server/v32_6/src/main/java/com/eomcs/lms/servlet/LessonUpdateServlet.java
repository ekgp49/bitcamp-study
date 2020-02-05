package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {
  List<Lesson> lessonList;

  public LessonUpdateServlet(List<Lesson> lessonList) {
    this.lessonList = lessonList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    Lesson lesson = (Lesson) in.readObject();
    int index = -1;
    for (int i = 0; i < lessonList.size(); i++) {
      if (lessonList.get(i).getNo() == no) {
        index = i;
        break;
      }
    }
    lessonList.set(index, lesson);
    out.writeUTF("OK");
  }
}
