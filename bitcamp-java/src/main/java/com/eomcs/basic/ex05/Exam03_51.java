// 논리 연산자 : 비트 연산
package com.eomcs.basic.ex05;

// 비트연산자 &를 이용하여 % 연산 구하기
public class Exam03_51 {
    public static void main(String[] args) {
      System.out.println(57 % 2);
      
      // 어떤 값에 대해 2로 나눈 나머지를 구하고 싶다면
      // 그 값으 ㅣ하위 1바이트만 추출하면 된다,
      System.out.println(57 & 0b1);
      System.out.println(57 & 0b11);
      System.out.println(57 & 0b111);
      System.out.println(57 & 0b1111);
    }
}

