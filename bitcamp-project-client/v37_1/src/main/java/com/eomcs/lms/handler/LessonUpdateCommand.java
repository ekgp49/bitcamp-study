package com.eomcs.lms.handler;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.util.Prompt;

public class LessonUpdateCommand implements Command {
  LessonDao lessonDao;
  Prompt prompt;

  public LessonUpdateCommand(LessonDao lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("수업 번호? ");
      Lesson oldLesson = null;

      try {
        oldLesson = lessonDao.findByNo(no);
      } catch (Exception e) {
        System.out.println("해당하는 번호의 수업 정보가 없습니다.");
        return;
      }

      Lesson newLesson = new Lesson();

      newLesson.setNo(oldLesson.getNo());
      newLesson.setTitle(prompt.inputString(String.format("수업명(%s)? ", oldLesson.getTitle()),
          oldLesson.getTitle()));
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
      lessonDao.update(newLesson);
      System.out.println("수업을 변경했습니다.");
    } catch (Exception e) {
      System.out.println("수업정보 변경 실패");
    }
  }
}
