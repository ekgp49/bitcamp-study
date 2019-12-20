package com.eomcs.basic.ex07.test;

public class Test01 {
  public static void main(String[] args) {
    
    // 입력값 x, 리턴값 x
    m1();
    
    // 입력값 o, 리턴값 x
    m2("김다혜");
    
    // 입력값 x, 리턴값 o
    String s;
    s = m3();
    System.out.println(s);
    
    // 입력값 o, 리턴값 o
    String s2 = m4("다혜");
    System.out.println(s2);
    
  }

  static void m1() {
    System.out.println("Hello!");
  }
  
  static void m2(String name) {
    // 함수 안에 선언된 변수를 local변수라 부른다.
    // 로컬 변수 중에서 함수가 호출될때 넘어온 값을 파라미터라 부른다
    // 함수를 호출할 때 넘겨주는 값을 아규먼트라고 부른다
    System.out.println("Hello, "+ name);
  }
  
  static String m3() {
    String message = "Hello!";
    return message;
  }
  
  static String m4(String name) {
    String message = name + "님 안녕하세요!";
    return message;
  }
}
