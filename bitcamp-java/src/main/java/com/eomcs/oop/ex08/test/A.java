package com.eomcs.oop.ex08.test;

class A1{

}

class A2 {
  // 이렇게 class A 외의 여러 패키지 멤버를 만드는건 가능하지만 유지보수를 위해서 하지 말라
}

// package member class
public class A {

  // nested class = none-static nested class = inner class
  class X {}

  // static nested class
  static class X2 {}

  void m() {
    // local class : 메서드 안에 선언된 클래스
    class Y{

      Object obj = new Object() {
        @Override
        public String toString() {
          return "익명 클래스";
        }
      };
    
    }
  }

}
