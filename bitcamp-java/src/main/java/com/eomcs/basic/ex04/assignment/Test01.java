package com.eomcs.basic.ex04.assignment;


import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    System.out.print("값1? : ");
    int a = keyScan.nextInt();

    System.out.print("값2? : ");
    int b = keyScan.nextInt();

    System.out.print("연산자(+, -, *, /)? ");
    String op = keyScan.next(); // 토큰 : 앞뒤 공백으로 구분되는 하나의 단어

    int result = 0;
    
    if (op.contentEquals("+")) {
      result = a + b;
    } else {
      System.out.println("하하");
      System.out.println("하하");
      System.out.println("하하");
      System.out.println("하하");
      System.out.println("하하");
      if (op.contentEquals("-")) {
        result = a - b;
      } else {
        if (op.contentEquals("*")) {
          result = a * b;
        } else {
          if (op.contentEquals("/")) {
            result = a / b;
          } else {
            System.out.println("=> 사용할 수 없는 연산자 입니다");
            return; //  System.out.printf("=> %d %s %d = %d\n", a, op, b, result); 안나오도록 할라면 
            //return함
          }
        }
      }
    } //원래 if else는 이런 구조임 첫번째 else 안에 새로운 if가 있는 구조
    
    keyScan.close();

    System.out.printf("=> %d %s %d = %d\n", a, op, b, result);
  }

}
