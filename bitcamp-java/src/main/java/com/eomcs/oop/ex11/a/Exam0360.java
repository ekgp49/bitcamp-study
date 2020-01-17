// local class - 로컬 클래스가 로컬 변수를 조회용으로만 사용하는 이유
package com.eomcs.oop.ex11.a;

public class Exam0360 {
  public static void main(final String[] args) {
    final Exam0360 obj = new Exam0360();
    final Runner r = obj.createRunner("다혜");
    // createRunner()의 리턴값은 이 메서드에 선언된 로컬클래스인 A의 객체이다.
    // A 객체는 Runner 규칙에 따라 만들었기 때문에
    // Runner 참조변수에 저장할 수 있다.
    r.run();
  }

  int iValue;

  Runner createRunner(final String name) {
    class A implements Runner {
      @Override
      public void run() {
        System.out.printf("%s님이 달립니다", name);
      }
    }
    return new A();
  }
}


interface Runner {
  void run();
}
