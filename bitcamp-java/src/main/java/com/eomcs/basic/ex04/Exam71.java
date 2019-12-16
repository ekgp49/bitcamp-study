package com.eomcs.basic.ex04;

public class Exam71 {
  int instanceVar;
  static int classVar;
  public static void main(String[] args) {
    int local;
    int local2;
    classVar = 200; //ok
//    instanceVar = 300;
  }
  
  static void m1() {
    int local;
//    local2 = 100;
    classVar = 100; //ok
//    instanceVar = 300;
  }
  
  //인스턴스 메서드
  void m2() {
    int local;
    
    classVar = 300;
    instanceVar = 200; //ok. static이 안붙은 변수 사용가능
    
  }
}