package com.eomcs.oop.ex09.g;

public class Exam0120 implements A {
  @Override
  public void m1() {}

  @Override
  public void m2() {
    // 인터페이스에서 구현했기 때문에
    // default method는 구현 안해도 컴파일 오류가 발생하지 않는다.
    A.super.m2();
  }
}
