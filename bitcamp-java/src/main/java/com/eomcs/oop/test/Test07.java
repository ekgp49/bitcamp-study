package com.eomcs.oop.test;

public class Test07 {
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
    System.out.println(m1);
    Member m2 = m1;

    m1 = new Member();
    m1.no = 200;
    System.out.println(m1);

    System.out.println(m1.no);
    System.out.println(m2.no);
    
    m2 = m1; //이제 처음 만들었던 인스턴스는 주소를 잃어버려 사용할 수 없다. = 가비지
    
    System.out.println(m1.no);
    System.out.println(m2.no);
  }

  static void input() {

  }

  static void print() {

  }
}
