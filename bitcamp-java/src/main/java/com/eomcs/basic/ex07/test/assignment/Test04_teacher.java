package com.eomcs.basic.ex07.test.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 n! 을 계산하라.
// 실행)
// 입력? 5
// 5! = 1 * 2 * 3 * 4 * 5 = 120
//
public class Test04_teacher {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("입력? ");
    // 사용자로부터 정수 값을 입력 받는다.
    int n = keyboard.nextInt();

    // n! 을 계산한다.
    int result = factorial(n);
    System.out.printf("%d! = ", n);
    for(int i = 1; i < n; i++) {
      System.out.printf("%d * ", i);
    }
    System.out.printf("%d = ", n);
    System.out.println(result);
    // 결과 값을 출력한다.
    keyboard.close();
  }

  static int factorial(int n) {
    // 코드를 완성하시오!
    if (n == 1) {
      return 1;
    }
    return n * factorial(n-1);
  }
}





