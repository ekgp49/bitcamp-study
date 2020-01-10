// Wrapper 클래스 - auto-boxing/auto-unboxing 
package com.eomcs.corelib.ex01;

public class Exam0221 {
  public static void main(String[] args) {
    
    Integer obj = 100; 
    // 내부적으로 Integer.valueOf(100)으로 바뀐다.
    // 즉 int 값이 obj에 저장되는 것이 아니라,
    // 내부적으로 Integer 객체가 생성되어 그 주소가 저장된다.
    // => 이렇게 int값을 자동으로 Integer 객체로 만드는 것을 auto-boxing이라 한다.
    
    // JDK1.5부터 auto-boxing, auto-unboxing 기능을 제공한다. => 컴파일러가 자동으로 함
    // => auto-boxing 
    //    int 값을 가지고 자동으로 Integer 랩퍼 객체를 만든다. 
    //    이렇게 객체 안에 값을 넣어 포장한다고 해서 "오토박싱"이라 부른다.

  }
}






