package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;
public class App3 {

  public static void main(String[] args) {
    // 한 카페의 리뷰 출력
    Scanner keyboard = new Scanner(System.in);

    String[] cafeName = new String[10000];
    String[] customer = new String[10000];
    String[] starRate = new String[10000];
    String[] content = new String[10000];
    String response;
    int count = 0;
    
    int[] viewCount = new int[10000];
    
    Date[] createdDate = new Date[10000]; 
    java.util.Date[] today = new java.util.Date[10000]; 
    String[] timeFormFromToday = new String[10000];
    
    for(int i = 0; i < 10000; i++) {
      System.out.println("리뷰");

      System.out.print("카페 상호는? : ");
      cafeName[i] = keyboard.nextLine();

      System.out.print("고객은? : ");
      customer[i] = keyboard.nextLine();

      System.out.print("별점은? : ");
      starRate[i] = keyboard.nextLine();

      System.out.print("내용은? : ");
      content[i] = keyboard.nextLine();
      
      createdDate[i] = new Date(System.currentTimeMillis()); 
      today[i] = new java.util.Date(); 
      timeFormFromToday[i] = String.format("%1$tp %1$tH:%1$tM:%1$tS ", today[i]);
      
      viewCount[i] = 0;

      System.out.println("계속 입력하시겠습니까? Y/N");
      System.out.print("=> ");

      response = keyboard.nextLine(); 
                          //next() 쓰면 토큰만 빼가고 WhiteSpace를 안가져가서 그 다음 카페상호는?이 입력이 안되는거였음
      
      count++;
      System.out.println();

      if(!response.equalsIgnoreCase("y")) {
        System.out.println("----------------------------------------");
        break;
      }
    }


    for(int i = 0; i < count; i++) {
      System.out.println("\n리뷰");
      System.out.printf("상호 : %s\n", cafeName[i]);
      System.out.printf("고객 : %s\n", customer[i]);
      System.out.printf("별점 : %s\n", starRate[i]);
      System.out.printf("업로드 시간 : %s %s\n", createdDate[i], timeFormFromToday[i]);
      System.out.printf("조회수 : %s\n", viewCount[i]);
      System.out.printf("내용 : %s\n", content[i]);
    }

    keyboard.close();
  }

}
