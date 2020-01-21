// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;



public class Exam0520 {

  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }
  }

  static interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {

    // Calculater c1 = MyCalculator::plus;
    // 위의 코드는 내부적으로 다음과 같다.
    Calculator c1 = new Calculator() {
      @Override
      public int compute(int a, int b) {
        // 기존 메서드가 메서드 레퍼런스로 전달 가능한지 여부는
        // 다음 코드를 참고하라

        return MyCalculator.plus(a, b);
      }
    };

    System.out.println(c1.compute(200, 17));
  }
}


