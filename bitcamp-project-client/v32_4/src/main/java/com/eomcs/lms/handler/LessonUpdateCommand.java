package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.Prompt;

public class LessonUpdateCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public LessonUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("수업 번호? ");

      out.writeUTF("/lesson/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      Lesson oldLesson = (Lesson) in.readObject();
      Lesson newLesson = new Lesson();

      newLesson.setTitle(prompt.inputString(String.format("수업명(%s)? ", oldLesson.getTitle()),
          oldLesson.getTitle()));
      newLesson.setNo(oldLesson.getNo());
      newLesson.setDescription(prompt.inputString("설명? ", oldLesson.getDescription()));
      newLesson.setStartDate(oldLesson.getStartDate());
      newLesson.setEndDate(oldLesson.getEndDate());
      newLesson.setTotalHours(prompt.inputInt(
          String.format("총수업시간(%d)? ", oldLesson.getTotalHours()), oldLesson.getTotalHours()));
      newLesson.setDayHours(prompt.inputInt(String.format("일수업시간(%d)? ", oldLesson.getDayHours()),
          oldLesson.getDayHours()));

      if (newLesson.equals(oldLesson)) {
        System.out.println("수업정보 변경을 취소했습니다.");
        return;
      }

      out.writeUTF("/lesson/update");
      out.writeInt(no);
      out.writeObject(newLesson);
      if (in.readUTF().equals("OK")) {
        System.out.println("수업정보를 변경했습니다.");
        return;
      }
      System.out.println("수업정보 변경 실패");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
