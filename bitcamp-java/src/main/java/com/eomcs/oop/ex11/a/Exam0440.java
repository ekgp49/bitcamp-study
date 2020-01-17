// anonymous class - 호출할 수퍼클래스의 생성자 지정하기
package com.eomcs.oop.ex11.a;

public class Exam0440 {
  static class A {
    String name;

    public A() {
      name = "이름없음";
    }

    public A(final String name) {
      this.name = name;
    }

    public void print() {
      System.out.println(name);
    }
  }

  public static void main(final String[] args) {
    // 익명 클래스를 정의할 때 호출할 수퍼 클래스의 생성자를 지정할 수 있다.
    // 문법 :
    // new 수퍼클래스명(파라미터, ...) {}
    //
    A a = new A("홍홍홍") {};
    a.print();

    a = new A() {};
    a.print();

  }

}
