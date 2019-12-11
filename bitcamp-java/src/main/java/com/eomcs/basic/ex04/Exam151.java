package com.eomcs.basic.ex04;

public class Exam151 {
  public static void main(String[] args) {
    int i;
    i = 100; 

    System.out.println(i);

    int j;
    j = 200;
    j = i;
    j = i * 3;
    j = Math.abs(-200);
    j = (i > 100) ? 1 : -1 ;
    // j = System.out.println(100); 얘는 표현식이 아니라서 값을 리턴하지 않기 때문에 오류남


    // 200 = i; 오류남 l-value는 무조건 변수가 와야함


  }
}