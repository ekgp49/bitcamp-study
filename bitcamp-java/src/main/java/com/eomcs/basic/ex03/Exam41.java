package com.eomcs.basic.ex03;

public class Exam41 {

  //리터럴
  public static void main(String[] args) {
   System.out.println('A');
   System.out.println('가');

   // UCS-2 코드값으로 문자를 지정할 수 있다. 
   // [\ u][UCS-2 코드]
   System.out.println('\u4eba'); 
   System.out.println('\u0041'); // A
   System.out.println('\u0030'); // 0
   System.out.println('\u0025'); // %
   System.out.println('\uac00'); // 가
   
    
  }
}