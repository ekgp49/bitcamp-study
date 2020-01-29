// 객체 출력 - 인스턴스의 값을 출력
// 바이너리 형식 - 바이트 배열
package com.eomcs.io.ex05;

import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("temp/test4.data");

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    // 인스턴스의 값을 출력하라!
    // 1) 이름 출력
    byte[] bytes = member.name.getBytes("UTF-8");
    out.write(bytes.length); // 1 바이트 // 다음 데이터는 문자열인데 그게 몇개야라고 알려주는 역할
    // 왜냐면 이름은 길이가 불고정되어있기 때문
    out.write(bytes); // 문자열 바이트

    // 2) 나이 출력 (4바이트)
    out.write(member.age >> 24);
    out.write(member.age >> 16);
    out.write(member.age >> 8);
    out.write(member.age);

    // 3) 성별 출력 (1바이트)
    if (member.gender)
      out.write(1);
    else
      out.write(0);

    out.close();

    System.out.println("데이터 출력 완료!");

  }

}
