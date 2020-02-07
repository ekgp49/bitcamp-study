package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDeleteServlet implements Servlet {
  List<Lesson> lessonList;

  public LessonDeleteServlet(List<Lesson> lessonList) {
    this.lessonList = lessonList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    int index = -1;
    for (int i = 0; i < lessonList.size(); i++) {
      if (lessonList.get(i).getNo() == no) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 수업정보가 없습니다.");
    } else {
      out.writeUTF("OK");
      lessonList.remove(index);
      out.writeUTF("수업정보를 삭제했습니다.");
    }
  }
}
