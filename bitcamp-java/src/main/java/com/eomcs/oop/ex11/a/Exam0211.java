// static nested class
package com.eomcs.oop.ex11.a;

public class Exam0211 {

  int iValue;
  void im() {}

  class A {
    int iValue;
    
    /*
     * 컴파일시 자동으로 생성되는 필드와 생성자
    Exam0211 this;
    
    public A(Exam0211 obj) {
      this = obj;
    }
    */
    
    
    void m1() {
      // 바깥 클래스의 인스턴스 멤버 이름이 inner class의 인스턴스 멤버 이름과 같을 경우
      // 기본은 inner class 안에서는 당연히 inner class 멤버를 가리킨다.
      iValue = 100; // A 객체의 iValue를 가리킨다.
      this.iValue = 100; // A 객체의 iValue를 가리킨다. 
      
      // 바깥 클래스의 인스턴스 멤버를 가리키고 싶다면 바깥클래스의 이름을 명시하라
      Exam0211.this.iValue = 100; // 바깥 클래스의 인스턴스 멤버를 가리킨다.
      Exam0211.this.im(); // 바깥 클래스의 인스턴스 멤버를 가리킨다.
      
      // inner class에서 바깥 클래스의 인스턴스 멤버를 사용할 수 있는 이유는?
      // => inner class의 객체를 생성하려면 반드시 바깥클래스의 인스턴스가 있어야한다.
      // 따라서 inner class의 인스턴스 메서드를 호출하는 시점에는 
      // 당연히 바깥클래스의 인스턴스를 알고 있는 상태이다.
    }
  }
  
  public static void main(String[] args) {
  }
}
