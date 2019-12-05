package com.ohoracs.basic.ex03;

public class Exam1 {

  //리터럴
  public static void main(String[] args) {
    System.out.println(78); // 10진수 표기법
    //78이 정수 리터럴이다.

    System.out.println(+78); //양수 리터럴
    System.out.println(-78);  //음수 리터럴

    System.out.println(0116); // 8진수 표기법. 맨 앞 숫자는 무조검 0으로 시작해야함
    System.out.println(-0116); 
    // 8진수 표기법 println은 진수에 상관없이 출력할 때 무조건 10진수로 출력한다.

    System.out.println(0x4e); //16진수 표기법 맨 앞에 0x 붙여줘야함
    System.out.println(-0x4e);  //16진수 표기법

    System.out.println(0b01001110); //2진수 표기법 맨 앞에 0b를 붙여줘야 함
    System.out.println(-0b01001110);  //2진수 표기법
  }
}