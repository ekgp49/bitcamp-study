package com.eomcs.basic.ex06.assignment;

// 사용자로부터 나이를 입력받아 성년/미성년 여부를 출력하라
public class Test04_teacher {

  public static void main(String[] args) {
    int age = Console.inputInt("나이? ");

    if (age >= 18) 
      System.out.println("성년입니다.");
    else System.out.println("미성년입니다");
  }

}

