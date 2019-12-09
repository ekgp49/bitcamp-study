package com.eomcs.basic.ex03;

public class Exam23 {

  //리터럴
  public static void main(String[] args) {
    
    System.out.println(-2147483648);// 4바이트(32bit) 최소 음수값 (2^8)^4
    System.out.println(2147483647); //4바이트 최대 양수값
   
    // System.out.println(2147483648); //4바이트 메모리 크기 초과

    System.out.println(-9_223_372_036_854_775_808L);

    System.out.println(9_223_372_036_854_775_807L);
    
    System.out.println(100);
    System.out.println(100L);
    
    
    System.out.println(Integer.MIN_VALUE); //4바이트 최소 정수값
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Long.MIN_VALUE); //8바이트 최소 정수값
    System.out.println(Long.MAX_VALUE);
  }
}