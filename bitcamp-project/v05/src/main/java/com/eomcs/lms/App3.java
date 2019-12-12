package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;
public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine(); //줄바꿈 기호 제거용
    
    System.out.print("내용? ");
    String content = keyboard.nextLine();
    
    keyboard.close();
 
    
    
    Date today = new Date(System.currentTimeMillis()); 
//    java.util.Date today = new java.util.Date();    java.util 안하면 java.sql로 간주 
    int viewCount = 0;
    
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", content);
    System.out.printf("작성일: %s\n", today);
    System.out.printf("조회수: %d\n", viewCount);
    
   
  }
}
