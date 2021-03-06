/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.eomcs.lms;
import java.sql.Date;
import java.util.Scanner;
public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in); 

    System.out.print("번호? ");
    int no = keyboard.nextInt();
    System.out.print("수업명? ");
    String title = keyboard.next();
    System.out.print("설명? ");
    String description = keyboard.next();
    System.out.print("시작일? ");
    Date startDate = Date.valueOf(keyboard.next()); //형식에 오류가 나면 실행 안됨
    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyboard.next());
    System.out.print("총수업시간? ");
    int totalHours = keyboard.nextInt();
    System.out.print("일수업시간? ");
    int dayHours = keyboard.nextInt();
    
    
    System.out.println();



    System.out.printf("번호: %d \n", no);
    System.out.printf("수업명: %s \n", title);
    System.out.printf("설명: %s \n", description);
    System.out.printf("기간: %s ~ %s \n", startDate, endDate); 
    System.out.printf("총수업시간: %d 시간 \n", totalHours);
    System.out.printf("일수업시간: %d 시간 \n", dayHours); 
    
    keyboard.close();
  }
}
