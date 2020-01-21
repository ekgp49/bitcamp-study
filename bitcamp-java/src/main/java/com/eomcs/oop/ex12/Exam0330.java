// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0330 {

  static interface Calculator {
    int compute(int start, int end);
  }

  static void test(Calculator c) {
    System.out.printf("결과: %d\n", c.compute(200, 100));
  }

  public static void main(String[] args) {

    test((a, b) -> a + b);
    test((a, b) -> a * b);
  }
}


