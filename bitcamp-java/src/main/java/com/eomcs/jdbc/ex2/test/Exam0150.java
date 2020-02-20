// 게시판 관리 - 삭제
package com.eomcs.jdbc.ex2.test;

import java.util.Scanner;

// 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 삭제하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0150 {

  public static void main(String[] args) throws Exception {
    try (Scanner scan = new Scanner(System.in);
        java.sql.Connection con = java.sql.DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        java.sql.PreparedStatement stmt =
            con.prepareStatement("delete from x_board where board_id=?")) {
      System.out.print("번호? ");
      int no = scan.nextInt();
      try {
        stmt.setInt(1, no);
        if (stmt.executeUpdate() > 0) {
          System.out.println("삭제하였습니다.");
        } else {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }
      } catch (Exception e) {
        System.out.println("삭제할 수 없는 번호입니다.");
      }
    }
  }
}


