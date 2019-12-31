// 캡슐화 문법 사용 후 - 개발자가 특정 필드를 직접 접근하지 못하게 막기
package com.eomcs.oop.ex07.a;

public class Exam0211 {
  public static void main(String[] args) {
    Score2 s1 = new Score2();
    s1.name = "옹길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    s1.compute();

    // 만약 개발자가 국영수 점수를 변경한 후 compute()를 호출 하지 않는다면 ??
    s1.eng = 100;
    s1.math = 100;
    // 원래 개발자 의도대로 사용한다면 다음과 같이 국영수 점수를 변경한 수 compute()를 호출했어야 한다.
    // s1.compute();
    // 그런데 그러지 않는 경우가 문제가 된다.
    // 해결책
    // => Exam0310.java를 보라
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        s1.name, s1.kor, s1.eng, s1.math, s1.getSum(), s1.getAver());
  }
}
