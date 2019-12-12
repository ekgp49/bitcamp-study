package com.bitcamp.myproject;

import java.util.Scanner;
public class App2 {

  public static void main(String[] args) {
    // 한 개의 카페 정보 출력
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("카페 상호는? : ");
    String cafeName = keyboard.nextLine();
    
    System.out.print("주소는? : ");
    String cafeAddress = keyboard.nextLine();
    
    System.out.print("연락처는? : ");
    String cafeCall = keyboard.nextLine();
    
    System.out.print("웹사이트는? : ");
    String cafeWebSite = keyboard.nextLine();
    
    System.out.print("오픈시간은? : ");
    String openTime = keyboard.nextLine();
 
    System.out.print("종료시간은? : ");
    String closeTime = keyboard.nextLine();
    
    System.out.print("정기 휴일은? : ");
    String holliday = keyboard.nextLine();
    
    System.out.print("메뉴는? : ");
    String cafeMenu = keyboard.nextLine();
    
    System.out.print("별점은? : ");
    String starRate = keyboard.nextLine();
    
    System.out.println();
    
    System.out.printf("상호 : %s\n", cafeName);
    System.out.printf("주소 : %s\n", cafeAddress);
    System.out.printf("연락처 : %s\n", cafeCall);
    System.out.printf("웹사이트 : %s\n", cafeWebSite);
    System.out.printf("영업시간 : %s ~ %s\n", openTime, closeTime);
    System.out.printf("정기휴일 : %s\n", holliday);
    System.out.printf("메뉴 : %s\n", cafeMenu);
    System.out.printf("별점 : %s\n", starRate);
    
//    System.out.println("상호 : 카페 0336");
//    System.out.println("주소 : 경기도 수원시 장안구 조원동");
//    System.out.println("연락처 : 010-5295-0336");
//    System.out.println("웹사이트 : www.cafe0336.com");
//    System.out.println("영업시간 : 6AM ~ 3PM");
//    System.out.println("정기휴일 : 격주 월요일");
//    System.out.println("메뉴 : 아메리카노");
//    System.out.println("별점 : 별5개");
//    

    keyboard.close();
  }

}
