package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
public class LessonHandler {
  
  Lesson[] lessons;
  int lessonCount = 0;
  public Scanner input;

  static final int LESSON_SIZE = 100;

  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessons = new Lesson[LESSON_SIZE];
  }
  
  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(input.nextInt());
    input.nextLine();
    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());
    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());
    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(input.next())); //0000-00-00 <-형식에 오류가 나면 실행 안됨
    // 문법 :    Date date = Date.valueOf("date_string");
    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));
    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());
    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine();

    this.lessons[this.lessonCount++] = lesson;
    System.out.println("저장하였습니다.");
  }

  public void listLesson() {
    for (int i = 0; i < this.lessonCount; i++) {
      Lesson l = this.lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }
}
