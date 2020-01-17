// anonymous class - 익명 클래스가 놓이는 장소 : 인스턴스 필드
package com.eomcs.oop.ex11.a;

public class Exam0510 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  A obj = new A() {
    public void print() {
      System.out.println("Hello!");
    };
  };
}
