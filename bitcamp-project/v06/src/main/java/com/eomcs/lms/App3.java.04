package com.eomcs.lms;


import java.util.Scanner;
import java.sql.Date;

// 반복문 사용
public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int[] no = new int[100];
    String[] title = new String[100];
    Date[] date = new Date[100];
    int[] viewCount = new int[100];
    String response = "";

    int count = 0;
    for (int i = 0; i < 100 ; i++) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용
      
      System.out.print("내용? ");
      title[i] = keyboard.nextLine();

      date[i] = new Date(System.currentTimeMillis());
      viewCount[i] = 0;
      
      count++;
      
      System.out.println("계속 입력하시겠습니까?(Y / N)");
      response = keyboard.nextLine();
    
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    //
    // Date today = new Date(System.currentTimeMillis());
    //// java.util.Date today = new java.util.Date(); java.util 안하면 java.sql로 간주
    //

    // int viewCount = 0;

    System.out.println();

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %d\n", no[i], title[i], date[i], viewCount[i]);
    }

    // System.out.printf("번호: %d\n", no);
    // System.out.printf("내용: %s\n", content);
    // System.out.printf("작성일: %s\n", today);
    // System.out.printf("조회수: %d\n", viewCount);

    keyboard.close();
  }
}
