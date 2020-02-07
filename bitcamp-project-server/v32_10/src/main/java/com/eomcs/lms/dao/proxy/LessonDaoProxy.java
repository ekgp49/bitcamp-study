package com.eomcs.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoProxy implements LessonDao {

  ObjectInputStream in;
  ObjectOutputStream out;

  public LessonDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Lesson> findAll() throws Exception {
    out.writeUTF("/lesson/list");
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }

    return (List<Lesson>) in.readObject();
  }

  @Override
  public int insert(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/add");
    out.writeObject(lesson);
    out.flush();
    String response = in.readUTF();

    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    System.out.println("저장하였습니다.");

    return 1;
  }

  @Override
  public Lesson findByNo(int no) throws Exception {
    out.writeUTF("/lesson/detail");
    out.writeInt(no);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      System.out.println(in.readUTF());
    }

    return (Lesson) in.readObject();
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    out.writeUTF("/lesson/update");
    out.writeInt(lesson.getNo());
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    out.writeUTF("/lesson/delete");
    out.writeInt(no);
    out.flush();
    if (in.readUTF().equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    System.out.println(in.readUTF());
    return 0;
  }

}
