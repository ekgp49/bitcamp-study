// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0331 {

  static interface Calculator {
    int compute(int start, int end);
  }

  static void test(Calculator c) {
    System.out.printf("결과: %d\n", c.compute(1, 100));
  }

  public static void main(String[] args) {
    // 람다 문법이 없다면 익명클래스로 객체를 완전히 적어서 넘겨줘야함.
    test(new Calculator() {
      @Override
      public int compute(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
          sum += i;
        }
        return sum;
      }
    });

    test((a, b) -> a * b);
  }
}


