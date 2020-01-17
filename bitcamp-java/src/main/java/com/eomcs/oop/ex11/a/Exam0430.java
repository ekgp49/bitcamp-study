// anonymous class - 추상클래스 구현
package com.eomcs.oop.ex11.a;

public class Exam0430 {
  // 인터페이스와 달리 클래스는 static으로 선언해야만 스태틱 멤버에서 접근할 수 있다.
  static abstract class My {
    public void print() {
      System.out.println("Hello");
    }
  }

  public static void main(final String[] args) {
    final My a = new My() {
      @Override
      public void print() {
        System.out.println("Hello2");
      }
    };
    a.print();

    // 익명클래스로 인터페이스 구현하기
  }

}
