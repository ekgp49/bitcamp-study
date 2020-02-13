package com.eomcs.lms.handler;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.util.Prompt;

public class LessonDeleteCommand implements Command {
  LessonDao lessonDao;
  Prompt prompt;

  public LessonDeleteCommand(LessonDao lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");
      lessonDao.delete(no);
    } catch (Exception e) {
      System.out.println("삭제 실패");
    }
  }
}
