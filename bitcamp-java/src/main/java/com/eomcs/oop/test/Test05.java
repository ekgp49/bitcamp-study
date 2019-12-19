package com.eomcs.oop.test;

public class Test05 {
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
    
    Member m1 = new Member();
    m1.no = 100;
    System.out.println(m1); // 인스턴스에 부여된 클래스 명과 고유번호가 출력된다. 주소가 아님.
    System.out.println(m1.no);
   // 레퍼런스의 주소를 없애는 방법
    m1 = null; // 주소가 없다는 의미로 실제 메모리에 0으로 설정된다.
//    System.out.println(m1.no);
  }

  static void input() {

  }

  static void print() {

  }
}
