// 다중 인터페이스 구현
package com.eomcs.oop.ex09.c;

// 클래스는 여러 개의 규칙을 이행할 수 있다.
public class Exam02 implements B, C {
  public void m2() {} // B 인터페이스 뿐만아니라,
  public void m1() {} // B의 수퍼인터페이스의 메서드까지 구현해야 한다.
  public void m3() {} // C의 인터페이스 구현 

  public static void main(String[] args) {
    Exam02 obj = new Exam02();
    // 한 클래스가 여러개의 인터페이스(사용 규칙)을 구현했다면
    // 각 인터페이스로 구분해서 그 객체를 사용할 수 있다.
    
    // B 인터페이스 레퍼런스에 담는다면 B 규칙에 따라 사용 할 수 있고
    B obj2 = obj;
    obj2.m1();
    obj2.m2();
//    obj2.m3();
    
    // C 인터페이스 레퍼런스에 담는다면 C 규칙에 따라 사용 할 수 있다.
    C obj3 = obj;
//    obj3.m1();
//    obj3.m2();
    obj3.m3();
    
    // Exam02객체를 B용도로 사용할지 C용도로 사용할지 어느 인터페이스 레퍼런스 변수에 담느냐에 따라
    // 결정할 수 있다.
    
  }
}
