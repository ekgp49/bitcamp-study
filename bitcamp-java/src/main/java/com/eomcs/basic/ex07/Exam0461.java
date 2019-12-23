package com.eomcs.basic.ex07;

//# 메서드 : 스택오버플로우 예외
//
public class Exam0461 {

  static int sum(int value) {
    if (value == 1)
      return 1;

    return value + sum(value - 1);
  }

  public static void main(String[] args) {
    // 스택오버플로우
    // 그런데 다음과 같이 큰 수를 계산할 때는 
    // 재귀호출의 수가 높아져서 쉽게 스택 메모리가 부족해지는 문제가 발생한다. 실행속도도 느림
    // 따라서 호출 단계가 깊지 않은 작은 수를 다룰 경우에는 
    // 재귀호출을 써도 되지만,
    // 호출 단계가 많은 큰 수를 다룰 때는 재귀호출 대신 반복문을 사용하라!
    System.out.println(sum(20000));
  }
}
