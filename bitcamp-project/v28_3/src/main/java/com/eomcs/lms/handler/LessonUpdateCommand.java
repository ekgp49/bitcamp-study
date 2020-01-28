package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateCommand implements Command {

  Prompt prompt;
  List<Lesson> lessonList;

  public LessonUpdateCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }

  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("수업 번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 강의가 없습니다.");
      return;
    }
    Lesson oldLesson = this.lessonList.get(index);

    Lesson newLesson = new Lesson();

    newLesson.setTitle(
        prompt.inputString(String.format("수업명(%s)? ", oldLesson.getTitle()), oldLesson.getTitle()));

    newLesson.setNo(oldLesson.getNo());
    newLesson.setStartDate(oldLesson.getStartDate());
    newLesson.setEndDate(oldLesson.getEndDate());

    prompt.inputString("설명? ", oldLesson.getDescription());

    newLesson.setTotalHours(prompt.inputInt(String.format("총수업시간(%d)? ", oldLesson.getTotalHours()),
        oldLesson.getTotalHours()));


    newLesson.setDayHours(prompt.inputInt(String.format("일수업시간(%d)? ", oldLesson.getDayHours()),
        oldLesson.getDayHours()));

    if (!oldLesson.equals(newLesson)) {
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다.");
    } else {
      System.out.println("수업 변경을 취소하였습니다");
    }
  }

  private int indexOfLesson(int no) {
    for (int i = 0; i < this.lessonList.size(); i++) {
      if (this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
