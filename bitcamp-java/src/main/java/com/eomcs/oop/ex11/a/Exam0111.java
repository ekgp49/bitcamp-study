// non-static nested class == inner class
package com.eomcs.oop.ex11.a;

public class Exam0111 {
  static class A {
    void m1() {
      
    }
  }
  
  static void m1() {
    // static nested class는 스태틱 멤버이기 때문엔 다른 스태틱 멤버가 사용할 수 있다
    A obj = new A();
  
  }
  
  void m2() {
    // 인스턴스 멤버는 스태틱 멤버를 사용 할 수 있기 때문에
    // 당연히 static nested member를 사용할 수 있다
    A obj2 = new A();
  }
  
}
