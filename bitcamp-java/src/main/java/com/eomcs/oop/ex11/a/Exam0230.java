// non-static nested class
package com.eomcs.oop.ex11.a;

class Exam0230_X {
  int sValue;
  void m1() {};
  
  class A {
    /*
     * 컴파일시 자동으로 생성되는 필드와 생성자
    Exam0230_X this;
    
    public A(Exam0230_X obj) {
      this = obj;
    }
    */
    void m1() {
    }
  }
}

public class Exam0230 {
  public static void main(String[] args) {
    
    // 다른 클래스의 인스턴스 멤버는 반드시 인스턴스가 있어야만 사용할 수 있다.
//    Exam0230_X.sValue = 100; // 컴파일 오류!
//    Exam0230_X.m1(); // 컴파일 오류!
    
    Exam0230_X obj = new Exam0230_X();

    // 다른 클래스에 있는 inner class의 레퍼런스를 선언하려면 해당 클래스를 지정해야 한다.
    // => 바깥 클래스명.inner class 명
    Exam0230_X.A a;
    
    // inner class도 마찬가지로 바깥 클래스의 인스턴스를 통해서면 객체를 생성할 수 있다.
    a = obj.new A();
    // 컴파일러는 inner class를 생성하는 위 코드를 다음과 같이 바꾼다
    /*
     * new A(obj)
     */
//    a = new Exam0230_X.A(); // 컴파일 오류! <- static nested class 객체 생성 형식
  }
}
