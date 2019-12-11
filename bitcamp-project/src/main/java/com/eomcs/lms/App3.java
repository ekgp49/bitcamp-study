package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;
public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호? ");
    String no = keyboard.nextLine();
    System.out.print("내용? ");
    String content = keyboard.nextLine();
    System.out.print("작성일? ");
    
    
    Date createdDate = new Date(System.currentTimeMillis()); 
    
    int viewCount = 0;
    
    System.out.println();
    
    System.out.printf("번호: %s\n", no);
    System.out.printf("내용: %s\n", content);
    System.out.printf("작성일: %s\n", createdDate);
    System.out.printf("조회수: %s\n", viewCount);
    
    keyboard.close();
  }
}
