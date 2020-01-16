// non-static nested class == inner class
package com.eomcs.oop.ex11.a;

// 다음과 같이 특정 클래스의 스태틱 멤버를 미리 선언해 두면
// 그 멤버를 사용할 때 일일히 클래스 이름을 작성할 필요가 없다.
/*
import static com.eomcs.oop.ex11.a.Exam0112_X.sValue;
import static com.eomcs.oop.ex11.a.Exam0112_X.A;
 */
import static com.eomcs.oop.ex11.a.Exam0112_X.*;
public class Exam0113 {

  static void m1() {
    // import static을 이용하면 패키지 멤버 클래스를 사용하는 것과 똑같은 방법으로
    // 클래스 이름을 생략할 수 있다.
    sValue = 100;

    // 그 클래스의 static nested class 또한 같은 방식으로 사용할 수 있다.
    Exam0112_X.A obj = new Exam0112_X.A();

  }

}
