package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;
public class App3 {

  public static void main(String[] args) {
    // 한 카페의 리뷰 출력
    Scanner keyboard = new Scanner(System.in);
    
    Date createdDate = new Date(System.currentTimeMillis()); 
  
  
    System.out.println("리뷰");
    
    
    System.out.print("카페 상호는? : ");
    String cafeName = keyboard.nextLine();
    
    System.out.print("고객은? : ");
    String customer = keyboard.nextLine();
    
    System.out.print("별점은? : ");
    String starRate = keyboard.nextLine();
    
    System.out.print("내용은? : ");
    String content = keyboard.nextLine();
    
    int viewCount = 0;
    
    System.out.println();
    
    System.out.printf("상호 : %s\n", cafeName);
    System.out.printf("고객 : %s\n", customer);
    System.out.printf("별점 : %s\n", starRate);
    System.out.printf("업로드 시간 : %s\n", createdDate);
    System.out.printf("조회수 : %s\n", viewCount);
    System.out.printf("내용 : %s\n", content);
    
    
//    
//    System.out.println("상호 : 카페 0336");
//    System.out.println("고객 : 김다혜");
//    System.out.println("별점 : 5개");
//    System.out.println("업로드 시간 : 2019-12-11");
//    System.out.println("내용 : 맛있어요");

    keyboard.close();
  }

}
