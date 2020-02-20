// 게시판 관리 - 변경
package com.eomcs.jdbc.ex2.test;

import java.util.Scanner;

// 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 제목? xxx
// 내용? xxxxx
// 변경하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0140 {

  public static void main(String[] args) throws Exception {
    try (Scanner scan = new Scanner(System.in);
        java.sql.Connection con = java.sql.DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111")) {
      System.out.print("번호? ");
      int no = scan.nextInt();
      scan.nextLine();
      java.sql.PreparedStatement stmt =
          con.prepareStatement("select board_id from x_board where board_id= ?");
      stmt.setInt(1, no);
      java.sql.ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        System.out.print("제목? ");
        String title = scan.nextLine();
        System.out.print("내용? ");
        String contents = scan.nextLine();

        stmt = con.prepareStatement("update x_board set title=?, contents=? where board_id = ?");
        stmt.setString(1, title);
        stmt.setString(2, contents);
        stmt.setInt(3, no);
        stmt.executeUpdate();

        System.out.println("변경하였습니다");
      } else {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      }
    }
  }
}


