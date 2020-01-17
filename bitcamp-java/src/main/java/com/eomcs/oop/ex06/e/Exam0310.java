// final 사용법 : 로컬 변수
package com.eomcs.oop.ex06.e;

public class Exam0310 {
  public void m1() {
    // 로컬 변수에 final을 붙이면 값을 변경할 수 없는 상수로 사용된다
    final int a = 1010;
//    a = 100; // 컴파일 오류!
    
    // 변수를 선언할 때 값을 초기화시키지 않고 다음에 초기화시킬 수 있다.
    final int b;
    b = 100;
    
    // 일단 한번 값이 초기화되면 변경할 수 없다.
//    b = 200; // 컴파일 오류!
    
  }
}
