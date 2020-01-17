// local class 와 파일 명
package com.eomcs.oop.ex11.a;

public class Exam0320 {
  void m0() {
    class X {
    }

    class A {
    }

    new X();
    new A();
  }

  void m1() {
    // 로컬 클래스를 컴파일하면 다음 규칙에 따라 .class 파일의 이름이 결정된다.
    // [바깥클래스명][$번호][로컬클래스명].class
    // ex> Exam0310$1A.class
    // => $다음에 오는 번호는 같은 이름을 가진 로컬 클래스가 등장한 순서이다.
    // => 로컬메서드가 어떤 메서드 안에 정의된 것인지는 구분하지 않는다.
    class A {
    }

    class B {
    }

    new A();
    new B();
  }

  void m2() {
    class A {
    }
    class X {
    }
    new X();
    new A();
  }
}


