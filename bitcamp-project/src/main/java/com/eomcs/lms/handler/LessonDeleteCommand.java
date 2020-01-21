package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDeleteCommand implements Command {

  Prompt prompt;
  List<Lesson> lessonList;

  public LessonDeleteCommand(Prompt prompt, List<Lesson> list) {
    // List 파라미터는 List 인터페이스를 구현한 객체를 받는다.
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

    this.lessonList.remove(index);
    System.out.println("수업을 삭제했습니다.");
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
