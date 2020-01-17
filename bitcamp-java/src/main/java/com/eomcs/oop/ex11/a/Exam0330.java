// local class - static 멤버에 선언된 local class
package com.eomcs.oop.ex11.a;

public class Exam0330 {
  public static void main(final String[] args) {
    // static 멤버는 인스턴스 없이 사용할 수 있다.
    // 즉, 다음과 같이 sm()을 호출 할 때
    // Exam0310 객체 없이 호출한다면 sm() 메서드 안에서는
    // 절대로 Exam0310 객체를 사용할 수 없는 것이다.
    // 그래서 static 메서드 안에 있는 로컬 클래스에서는
    // 바깥 클래스의 객체를 사용할 수 없다.
    Exam0330.sm();
  }

  // static method의 로컬 클래스 사용법
  static void sm() {
    class A {
      // 스태틱 메서드 에서는 바깥 클래스의 인스턴스 주소를 알 수 없기 때문이
      // 스태틱 안에 로컬 클래스를 정의하는 경우
      // 컴파일러는 바깥 클래스의 인스턴스 주소를 저장할 필드를 만들지 앉는다.
      void m1() {
        // 로컬 클래스가 static 멤버에 정의된 경우
        // 바깥 클래스의 인스턴스 주소를 모르기 때문에
        // 바깥 클래스의 인스턴스 멤버를 사용할 수 없다.
        // 한마디로 표현하면 컴파일러가 바깥 클래스의 인스턴스 주소를 담을 필드를
        // 만들지 않았기 때문에 사용할 수 없다.
        // Exam0330.this.iValue = 100; // 컴파일 오류!
      }
    }

    final A obj = new A();
    obj.m1();
  }

  int iValue;
}
