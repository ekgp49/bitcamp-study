// non-static nested class
package com.eomcs.oop.ex11.a;

class Exam0231_X {
  class A {
    String name;
    int age;
    
    public A(String name, int age) {
      this.name = name;
      this.age = age;
    }
    /*
     * 컴파일시 자동으로 생성되는 필드와 생성자
    Exam0231_X this;
    
    public A(Exam0231_X obj) {
      this = obj;
    }
    */
  }
}

public class Exam0231 {
  public static void main(String[] args) {
    
    // 다른 클래스의 인스턴스 멤버는 반드시 인스턴스가 있어야만 사용할 수 있다.
//    Exam0231_X.sValue = 100; // 컴파일 오류!
//    Exam0231_X.m1(); // 컴파일 오류!
    
    Exam0231_X obj = new Exam0231_X();

    // 다른 클래스에 있는 inner class의 레퍼런스를 선언하려면 해당 클래스를 지정해야 한다.
    // => 바깥 클래스명.inner class 명
    Exam0231_X.A a;
    
    // inner class도 마찬가지로 바깥 클래스의 인스턴스를 통해서면 객체를 생성할 수 있다.
//    a = obj.new A();
    // 컴파일러는 inner class를 생성하는 위 코드를 다음과 같이 바꾼다
    /*
     * new A(obj)
     */
//    a = new Exam0231_X.A(); // 컴파일 오류! <- static nested class 객체 생성 형식
    a = obj.new A("옹", 12);
 // 컴파일러는 inner class를 생성하는 위 코드를 다음과 같이 바꾼다
    /*
     * new A(obj, "옹", 12);
     */
  }
}
