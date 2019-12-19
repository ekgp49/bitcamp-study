package com.eomcs.oop.test;

public class Test03 {
  public static void main(String[] args) {

    // 개발자가 임의로 만든 데이터타입. class는 회원 정보를 담을 수 있는 메모리의 설계도 = Member
    class Member {
      int no;
      String name;
      int birthYear;
      char gender; 
      float height;
      float weight;
      boolean personalTraining;
    }
    
    // 이렇게 class 설계도로 만든 메모리(인스턴스(instance) = 객체(object))의 주소를 저장하는 변수를 레퍼런스라고 한다.
    Member m1;
    // m1은 메모리의 주소를 저장하는 변수인데 메모리의 주소를 저장하지 않으면 사용할 수 없다.
    // 자바 원시 데이터 타입은 그냥 변수를 선언하는 순간 메모리가 준비된다. 즉 변수가 곧 메모리이다.
    int i = 100; // ok
//    m1.no = 100; // 못씀
    //메모리 생성 후 주소를 할당해야 쓸수있음
    m1 = new Member();
    m1.no = 100;
  }

  static void input() {

  }

  static void print() {

  }
}
