package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;
public class LessonHandler {

  public Scanner input;
  ArrayList<Lesson> lessonList;

  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessonList = new ArrayList<>();
  }

  public LessonHandler(Scanner input, int capacity) {
    this.input = input;
    this.lessonList = new ArrayList<>(capacity);
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
    lesson.setStartDate(Date.valueOf(input.next())); 
    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));
    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());
    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine();

    this.lessonList.add(lesson);
    System.out.println("저장하였습니다.");
  }

  public void listLesson() {
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }

  public void detailLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfLesson(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 강의가 없습니다.");
      return;
    }
    
    Lesson lesson = this.lessonList.get(index);
    System.out.printf("번호: %d\n", lesson.getNo());
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getDescription());
    System.out.printf("시작일: %s\n", lesson.getStartDate());
    System.out.printf("종료일: %s\n", lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }
  
  public void updateLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfLesson(no);
    
    if (index == -1) {
      System.out.println("해당 번호의 강의가 없습니다.");
      return;
    }
    
    Lesson oldLesson = this.lessonList.get(index);
    String inputStr = null;
    boolean changed = false;

    Lesson newLesson = new Lesson();
    
    System.out.printf("수업명(%s)? ", oldLesson.getTitle());
    inputStr = input.nextLine();
//    if (inputStr.equals("")) {
//      
//    }
    
    if (inputStr.length() == 0) {
      newLesson.setTitle(oldLesson.getTitle());
    } else {
      newLesson.setTitle(inputStr);
      changed = true;
    }

    newLesson.setNo(oldLesson.getNo());
    newLesson.setStartDate(oldLesson.getStartDate()); 
    newLesson.setEndDate(oldLesson.getEndDate());
    System.out.print("설명? ");
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setDescription(oldLesson.getDescription());
    } else {
      newLesson.setDescription(inputStr);
      changed = true;
    }
    
    System.out.printf("총수업시간(%d)?", oldLesson.getTotalHours());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setTotalHours(oldLesson.getTotalHours());
    } else {
      newLesson.setTotalHours(Integer.parseInt(inputStr));
      changed = true;
    }
    
    System.out.printf("일수업시간(%d)?", oldLesson.getDayHours());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setDayHours(oldLesson.getDayHours());
    } else {
      newLesson.setDayHours(Integer.parseInt(inputStr));
      changed = true;   
    }

    if (changed) {
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다.");
    } else {
      System.out.println("수업 변경을 취소하였습니다");
    }
  }

  public void deleteLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfLesson(no);
    
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
