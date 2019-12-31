package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  Lesson[] lessons;
  int size = 0;
  static final int DEFAULT_SIZE = 100;

  public LessonList() {
    lessons = new Lesson[DEFAULT_SIZE];
  }

  public LessonList(int capacity) {
    if (capacity < DEFAULT_SIZE || capacity > 10000) {
      lessons = new Lesson[DEFAULT_SIZE];
    } else {
      lessons = new Lesson[capacity];
    }
  }

  public void add(Lesson lesson) {
    if(this.size == this.lessons.length) {
      int oldCapacity = this.lessons.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      /*
      Lesson[] arr = new Lesson[newCapacity];
      for (int i = 0; i < oldCapacity; i++) {
        arr[i] = lessons[i];
      }
      lessons = arr; 
       */
      this.lessons = Arrays.copyOf(lessons, newCapacity);
    }
    this.lessons[this.size++] = lesson;
  }

  public Lesson[] toArray() {
    /* Lesson[] lesson = new Lesson[LESSON_SIZE];
    for (int i = 0; i < LESSON_SIZE; i++) {
      lesson[i] = this.lessons[i]; 
    }
    return lesson;
     */
    return Arrays.copyOf(this.lessons, this.size);
  }

}
