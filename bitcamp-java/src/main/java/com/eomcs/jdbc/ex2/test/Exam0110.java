// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0110 {

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    String title;
    String contents;
    System.out.println("제목?");
    title = scan.nextLine();
    System.out.println("내용?");
    contents = scan.nextLine();
    System.out.println("등록하시겠습니까?(Y/n)");
    if (scan.nextLine().equalsIgnoreCase("y")) {
      try (
          Connection con =
              DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
          java.sql.PreparedStatement stmt =
              con.prepareStatement("insert into x_board(title, contents) value(?, ?)")) {
        stmt.setString(1, title);
        stmt.setString(2, contents);
        System.out.println("등록했습니다");
        stmt.executeUpdate();
      }

    } else {
      System.out.println("등록을 취소했습니다.");
    }
    scan.close();
  }
}


