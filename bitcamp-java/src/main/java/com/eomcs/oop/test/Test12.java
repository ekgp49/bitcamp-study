package com.eomcs.oop.test;

public class Test12 {
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
    // 다음과 같이 일반적인 방법으로 레퍼런스를 선언하면 너무 길어져서 코딩 할 수 없다.
    
//    Member m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13;
//    int count = 0;
//    while (count < 300) {
//      count++;
//      new Member();
//    }
    // 배열을 사용하면 쉽게 해결할 수 있다.
    Member[] arr = new Member[3000];
    //주의; Member 인스턴스 주소를 담을 레퍼런스 변수를 3000개 만드는거지 Member 인스턴스 3000개를 만든게 아니다.
    // 배열 문법으로 인스턴스를 3000개 만드는 방법은 없다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    int count = 0;
    while (count < 3000) {
      arr[count] = new Member();
      count++;
    }
    
    //arr[0] = new Member();

    System.out.println(arr[1]);
  }

  static void input() {

  }

  static void print() {

  }
}
