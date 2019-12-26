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
public class Test05_teacher {


  public static void main(String[] args) {
    // 사용자로부터 밑변의 길이를 입력 받는다.
    Scanner keyboard = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int base = keyboard.nextInt();
    keyboard.close();

    // 직삼각형을 출력한다.
    printTriangle(base);
  }

  static void printTriangle(int base) {
    // 코드를 완성하시오!
    if (base == 0) {
      return;
    }
    printTriangle(base - 1); // 재귀호출을 sysout출력전에 놓으면 깊숙히 들어가면서 먼저 출력함.
    for (int i = 0; i < base; i++) {
      System.out.print("*");
    }
    System.out.println();
  }
}





