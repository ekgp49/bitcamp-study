package com.eomcs.oop.ex02.study;

public class Score {
  // 변수 선언을 통해 메모리 구조 설계 : 인스턴스 변수
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  // 메서드를 통해 값을 계산하는 기능 추가 : 연산자 정의
  // => 합계와 평균을 계산하는 기능을 추가한다.
  public void calculator() {
    // 인스턴스 메서드는 인스턴스 주소를 받는 내장 변수(built-in)이 있다.
    // 그 변수의 이름은 this이다.
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
