// 사용자 입력을 받는 코드를 별도의 메서드로 분리한다.
package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;
public class LessonHandler {

  Prompt prompt;
  ArrayList<Lesson> lessonList;

  public LessonHandler(Prompt prompt) {
    this.prompt = prompt;
    this.lessonList = new ArrayList<>();
  }

  public LessonHandler(Prompt prompt, int capacity) {
    this.prompt = prompt;
    this.lessonList = new ArrayList<>(capacity);
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    lesson.setNo(prompt.inputInt("번호? "));
    lesson.setTitle(prompt.inputString("수업명? "));
    lesson.setDescription(prompt.inputString("설명? "));
    lesson.setStartDate(prompt.inputDate("시작일? ")); 
    lesson.setEndDate(prompt.inputDate("종료일? "));
    lesson.setTotalHours(prompt.inputInt("총수업시간? "));
    lesson.setDayHours(prompt.inputInt("일수업시간? "));

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
    int index = indexOfLesson(prompt.inputInt("수업 번호? "));
    
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
    int index = indexOfLesson(prompt.inputInt("수업 번호? "));
    
    if (index == -1) {
      System.out.println("해당 번호의 강의가 없습니다.");
      return;
    }
    Lesson oldLesson = this.lessonList.get(index);

    Lesson newLesson = new Lesson();
    
    newLesson.setTitle(prompt.inputString(
        String.format("수업명(%s)? ", oldLesson.getTitle()),
        oldLesson.getTitle()));
    
    newLesson.setNo(oldLesson.getNo());
    newLesson.setStartDate(oldLesson.getStartDate()); 
    newLesson.setEndDate(oldLesson.getEndDate());
    
    prompt.inputString("설명? ", oldLesson.getDescription());
    
    newLesson.setTotalHours(prompt.inputInt(
        String.format("총수업시간(%d)? ", oldLesson.getTotalHours()),
        oldLesson.getTotalHours()));
    
    
    newLesson.setDayHours(prompt.inputInt(
        String.format("일수업시간(%d)? ", oldLesson.getDayHours()),
        oldLesson.getDayHours()));
    
    if (!oldLesson.equals(newLesson)) {
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다.");
    } else {
      System.out.println("수업 변경을 취소하였습니다");
    }
    
  }

  public void deleteLesson() {
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
  
  // 새로 add 할때
 
}
