package com.eomcs.oop.test;

public class Test02 {
  public static void main(String[] args) {

    //개발자가 임의로 만든 데이터타입
    class Member {
      int no;
      String name;
      int birthYear;
      char gender; 
      float height;
      float weight;
      boolean personalTraining;
    }
    
    //이렇게 class 설계도로 만든 메모리(인스턴스(instance) = 객체(object))의 주소를 저장하는 변수를 레퍼런스라고 한다.
    Member m1 = new Member();
    
    m1.no = 100;
    m1.name = "김다혜";
    m1.birthYear = 1994;
    
  }

  static void input() {

  }

  static void print() {

  }
}
