// StringBuffer - 문자열 비교
package com.eomcs.corelib.ex01;

public class Exam0121 {
  public static void main(String[] args) {
    // StringBuffer를 사용할 때 주의사항!
    // StringBuffer의 내용물을 비교할 때 equals() 사용해봐야 소용없다.
    // == 연산자와 같은 결과를 출력한다.
    StringBuffer b1 = new StringBuffer("Hello");
    StringBuffer b2 = new StringBuffer("Hello");
    System.out.println(b1 == b2); // false
    // => b1 과 b2의 인스턴스가 다르니까 당연히 false이다.

    System.out.println(b1.equals(b2)); // false
    // => StringBuffer은 Object에서 상속받은 equals를 오버라이딩하지 않았다.
    // => 따라서 원래 Object의 equals()를 사용한다.
    // => 그래서 결과는 false이다

    // 해결책?
    // => StringBuffer에서 String을 꺼내 비교하라!
    System.out.println(b1.toString() == b2.toString()); // false
    System.out.println(b1.toString().getClass());
    System.out.println(b1.toString().equals(b2.toString())); // true
  }
}





