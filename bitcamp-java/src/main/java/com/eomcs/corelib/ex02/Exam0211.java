// Wrapper 클래스 - 생성자와 valueOf
package com.eomcs.corelib.ex02;

public class Exam0211 {
  public static void main(String[] args) {
    Integer i = new Integer(127); // ==> int
    Integer i2 = new Integer(127);
    System.out.println(i == i2); // false

    // -128 ~ 127 범위의 수는 자주 사용되는 수이기 때문에
    // 이 범위의 수를 가지고 Integer 객체를 만들면 내부 메모리(cache)에 보관한다.
    // => 그래서 같은 값의 객체가 여러개 생성되지 않도록 한다.
    Integer i3 = Integer.valueOf(127);
    Integer i4 = Integer.valueOf(127);
    System.out.println(i3 == i4); // true

    // 그 범위 외의 수는 새 인스턴스를 생성한다.
    Integer i5 = Integer.valueOf(128);
    Integer i6 = Integer.valueOf(128);
    System.out.println(i5 == i6); // false

    // 결론!
    // 그냥 == 쓰지말고 equals()를 사용하라
  }
}


