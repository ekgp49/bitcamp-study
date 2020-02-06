package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.json.LessonJsonFileDao;

public class LessonDeleteServlet implements Servlet {
  LessonJsonFileDao lessonDao;

  public LessonDeleteServlet(LessonJsonFileDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();

    if (lessonDao.delete(no) > 0) {
      out.writeUTF("OK");
      out.writeUTF("수업정보를 삭제했습니다.");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 수업정보가 없습니다.");
    }
  }
}
