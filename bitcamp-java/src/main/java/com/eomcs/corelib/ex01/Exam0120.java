// String - 문자열 비교
package com.eomcs.corelib.ex01;

public class Exam0120 {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    String s3 = "Hello";

    // equals() ?
    // => Object에 정의되어 있는 메서드이다. 인스턴스가 같은지 비교한다.
    System.out.println(s1.equals(s2));
    System.out.println(s1.equals(s3));
    System.out.println(s2.equals(s3));

    // => String클래스에서 오버라이딩해서 인스턴스가 아니라 인스턴스의 데이터를 비교하도록 변경하였다.
    // => s1, s2, s3의 내용물이 같기 때문에 eqauls의 리턴값은 true이다.
    
    // 결론
    // String 인스턴스의 데이터가 같은 지 비교할 때는
    // equals()라는 메서드를 사용하라!
  }
}





