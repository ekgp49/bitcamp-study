package com.eomcs.oop.ex02.study;

public class Calculator {
  
  // 메서드가 작업한 결과를 보관하기 위해 필드 문법 도입
  int result;
  
  // 개별적으로 관리되는 인스턴스 변수 result를 사용하고 싶다면
  // 파라미터로 인스턴스의 주소를 받아야 한다.
  // 스태틱 메서드에서 인스턴스의 필드나 메서드를 사용할 수 없다
  // 파라미터로 인스턴스 주소를 받아야 한다. reserved keyword
  void plus(int value) {
    this.result += value;
  }
  
  void minus(int value) {
    this.result -= value;
  }
  
  void multiple(int value) {
    this.result *= value;
  }
  
  void divide(int value) {
    this.result /= value;
  }
}
