package com.bitcamp.myproject;

import java.util.Scanner;
public class App {
  public static void main(String[] args) {
    // 카페 명단 출력
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("지역은? : ");
    String cafeArea = keyboard.nextLine();
    
    System.out.print("카페 수는? : ");
    String cafeNum = keyboard.nextLine();
    
    System.out.print("카페 상호는? : ");
    String cafeName = keyboard.nextLine();    
    
    System.out.print("메뉴는? : ");
    String cafeMenu = keyboard.nextLine();
    
    System.out.print("별점은? : ");
    String starRate = keyboard.nextLine();
    
    System.out.println();
    
    System.out.println("카페 명단");
    System.out.printf("지역 : %s\n", cafeArea);
    System.out.printf("카페 수 : %s\n", cafeNum);
    System.out.printf("상호 : %s\n", cafeName);
    System.out.printf("메뉴 : %s\n", cafeMenu);
    System.out.printf("별점 : %s\n", starRate);
    
    keyboard.close();
    
  }

}
