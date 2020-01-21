// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;

public class Exam0530 {

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


  static interface Calculator1 {
    double compute(int a, int b);
  }

  static interface Calculator2 {
    float compute(int a, int b);
  }

  static interface Calculator3 {
    short compute(int a, int b);
  }

  static interface Calculator4 {
    void compute(int a, int b);
  }

  static interface Calculator5 {
    Object compute(int a, int b);
  }

  static interface Calculator6 {
    String compute(int a, int b);
  }


  public static void main(String[] args) {
    // 리턴타입 int =====> double
    Calculator1 c1 = MyCalculator::plus; // OK!

    // 리턴타입 int =====> float
    Calculator2 c2 = MyCalculator::plus; // OK!

    // 리턴타입 int =====> short
    // Calculator3 c3 = MyCalculator::plus; // 컴파일 오류!

    // 리턴타입 int =====> void
    Calculator4 c4 = MyCalculator::plus; // OK!

    // 리턴타입 int =====> Object
    Calculator5 c5 = MyCalculator::plus; // OK!

    // 리턴타입 int =====> String
    // Calculator6 c6 = MyCalculator::plus; // 컴파일오류!

    // => 메서드 레퍼런스를 지정할 때 리턴타입 규칙
    // 1) 같은 리턴 타입이어야 한다.
    // 2) void
    // 3) 암시적 형변환이 가능한 타입
    // 4) auto-boxing 가능한 타입
    System.out.println(c1.compute(100, 200));
    System.out.println(c2.compute(100, 200));
    c4.compute(100, 200); // plus() 메서드의 리턴값은 무시한다.
    System.out.println(c5.compute(100, 200));
  }
}


