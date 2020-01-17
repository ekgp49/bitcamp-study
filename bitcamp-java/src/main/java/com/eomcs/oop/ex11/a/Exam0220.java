// non-static nested class = inner class
package com.eomcs.oop.ex11.a;

public class Exam0220 {

  // 인스턴스가 있어야지만 사용할 수 있는 클래스 = inner class
  class A {
    /*
     * 컴파일시 자동으로 생성되는 필드와 생성자
    Exam0220 this;
    
    public A(Exam0220 obj) {
      this = obj;
    }
    */
    void m1() {
    }
  }
  
  static void m1() {
    // static 멤버는 this라는 내장 변수가 없기 때뮨에 인스턴스 멤버를 사용할 수 없다
    // 단, 레퍼런스 변수를 만드는 것은 허용한다.
    // 인스턴스 없이 생성자를 호출할 수 없다.
    A obj2;
//    obj2 = new A();  // 인스턴스 없이 inner class의 생성자를 호출할 수 없다

    
    Exam0220 x = new Exam0220();
    A obj;
    obj = x.new A();
  }
  
  void m2() {
    // 인스턴스 멤버는 this라는 내장 변수가 있기 때문에 다른 인스턴스 멤버를 사용할 수 있다. 
    A obj;
    obj = this.new A(); // inner class의 객체를 생성할 때 바깥 클래스의 객체가 있어야 한다.
    // 컴파일러는 inner class를 생성하는 위 코드를 다음과 같이 바꾼다
    // => A 클래스에 기본 생성자가 호출되는 것이 아니다.
    // => 컴파일러가 바깥 클래스의 객체 주소를 받으려고 추가한
    //    생성자를 호출하는 코드로 바뀐다.
    /*
     * new A(this)
     */
    
    obj = new A(); // 다른 인스턴스멤버를 사용하는 것처럼 this 생략 가능
    // 컴파일러는 inner class를 생성하는 위 코드를 다음과 같이 바꾼다
    /*
     * new A(this)
     */
  }

  public static void main(String[] args) {
  }
}
