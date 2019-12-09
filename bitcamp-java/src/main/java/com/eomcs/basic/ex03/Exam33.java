package com.eomcs.basic.ex03;

public class Exam33 {

  //리터럴
  public static void main(String[] args) {
    //부동소수점 최소최대값
    System.out.println(Double.MAX_VALUE); //8바이트 부동소수점
    System.out.println(Double.MIN_VALUE);

    //4바이트
    System.out.println(Float.MAX_VALUE);
    System.out.println(Float.MIN_VALUE);

    System.out.println(3.1415926535F); 
    System.out.println(3.1415926F);
    System.out.println(3.141592F); // ok
    System.out.println(31415.92F); // ok
    System.out.println(3141.592F); // ok
    System.out.println(314159.2F); // ok
    System.out.println(314159.26F);
    //유효자릿수 7개

    System.out.println((1.1f + 0.2f) == 1.3f); // false 뜸.
    
  }
}