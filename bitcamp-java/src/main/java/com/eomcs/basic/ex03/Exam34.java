package com.eomcs.basic.ex03;

public class Exam34 {

  //리터럴
  public static void main(String[] args) {
    //부동소수점 메모리에 저장하는 방법

    System.out.println(3.141592F); // ok
    System.out.println(31415.92F); // ok
    System.out.println(3141.592F); // ok
    System.out.println(314159.2F); // ok
    System.out.println(314159.26F);
    System.out.println(3.1415926535F); 
    System.out.println(3.1415926F);
    //유효자릿수 7개

    //8바이트 부동소수점 유효자릿수 : 15자리
    System.out.println(3.141592653589793); //ok
    System.out.println(31415926.53589793); 
    System.out.println(314159265358979.3); 

    System.out.println(914159265358979.3); 
    System.out.println(91415926.53589793); 
    System.out.println(9.141592653589793);

    System.out.println(91415926535979.3); 
    System.out.println(91415926.5359793); 
    System.out.println(9.14159265359793);

    System.out.println((1.1f + 0.2f) == 1.3f); // false 뜸.
    
    System.out.println(7 * 0.1);
  }
}