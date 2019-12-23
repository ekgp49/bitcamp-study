package com.eomcs.basic.ex07.test.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****
//
public class Test05 {


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    // 사용자로부터 밑변의 길이를 입력 받는다.
    int base = keyboard.nextInt();

    // 직삼각형을 출력한다.
    printTriangle(base);
    
    keyboard.close();
  }
  static int count = 0;

  static void printTriangle(int base) {
    count++;
    // 코드를 완성하시오!
    if (count != 0 && count <= base) {
      for (int i = 0; i < count; i++) {
        System.out.print("*");
      }
      System.out.println();
      printTriangle(base);
    }
  }
}





