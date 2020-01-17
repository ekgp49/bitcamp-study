// anonymous class - 람다문법 사용
package com.eomcs.oop.ex11.a;

public class Exam0431 {
  // 인터페이스와 달리 클래스는 static으로 선언해야만 스태틱 멤버에서 접근할 수 있다.
  static abstract class My {
    public void print() {
      System.out.println("Hello");
    }
  }

  public static void main(final String[] args) {
    // 클래스에 대해서는 람다 문법을 사용할 수 없다
    final My a = () -> System.out.println("Hello2"); // 컴파일 오류!
    a.print();

  }

}
