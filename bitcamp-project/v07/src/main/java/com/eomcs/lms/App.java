package com.eomcs.lms;
import java.sql.Date;
import java.util.Scanner;
public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in); 
    final int SIZE = 100;
    
    // 클래스?
    // 클래스는 사용 정의 데이터 타입을 만들 때 사용하는 문법이다.
    class Lesson {
      int no;
      String title;
      String description;
      Date startDate;
      Date endDate;
      int totalHours;
      int dayHours;
    }

    Lesson[] lessons = new Lesson[SIZE];
    for (int i = 0; i < SIZE; i++) {
      lessons[i] = new Lesson();
    }

    int count = 0;
    for (int i = 0; i < SIZE; i++) {
      count++;

      Lesson lesson = lessons[i];

      System.out.print("번호? ");
      lesson.no = keyboard.nextInt();
      System.out.print("수업명? ");
      lesson.title = keyboard.next();
      System.out.print("설명? ");
      lesson.description = keyboard.next();
      System.out.print("시작일? ");
      lesson.startDate = Date.valueOf(keyboard.next()); //0000-00-00 <-형식에 오류가 나면 실행 안됨
      // 문법 :    Date date = Date.valueOf("date_string");
      System.out.print("종료일? ");
      lesson.endDate = Date.valueOf(keyboard.next());
      System.out.print("총수업시간? ");
      lesson.totalHours = keyboard.nextInt();
      System.out.print("일수업시간? ");
      lesson.dayHours = keyboard.nextInt();

      keyboard.nextLine();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }

    System.out.println();

    for (int i = 0; i < count; i++) {
      Lesson lesson = lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          lesson.no, lesson.title, lesson.startDate, lesson.endDate, lesson.totalHours);
    }
    keyboard.close();
  }
}
