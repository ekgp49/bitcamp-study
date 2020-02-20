// 게시물 관리 - 조회
package com.eomcs.jdbc.ex2.test;

import java.util.Scanner;

// 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 제목: aaa
// 내용: aaaaa
// 등록일: 2019-1-1
// 조회수: 2
//
// 번호? 100
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0130 {

  public static void main(String[] args) throws Exception {
    try (Scanner scan = new Scanner(System.in);
        java.sql.Connection con = java.sql.DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        java.sql.PreparedStatement stmt =
            con.prepareStatement("select * from x_board where board_id= ?")) {
      System.out.print("번호? ");
      int no = scan.nextInt();
      stmt.setInt(1, no);
      java.sql.ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        System.out.printf("제목: %s\n", rs.getString("title"));
        System.out.printf("내용: %s\n", rs.getString("contents"));
        System.out.printf("등록일: %s\n", rs.getDate("created_date"));
        System.out.printf("조회수: %d\n", rs.getInt("view_count"));
      } else {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      }
    }
  }
}


