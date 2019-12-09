package com.eomcs.basic.ex03;

public class Exam32 {

  //리터럴
  public static void main(String[] args) {
    
    System.out.println(3.141592653589793); //8바이트 부동소수점
    System.out.println(3.141592653589793D);
    System.out.println(3.141592653589793d);
    
    System.out.println(3.141592653589793f); //4바이트로 바꾼거임 컴파일 오류 안발생
    System.out.println(3.141592653589793F);
  }
}