// 게시물 관리 - 목록
package com.eomcs.jdbc.ex2.test;

// 다음과 같이 게시물 목록을 출력하라!
// 게시물 번호를 내림차순으로 정렬하라.
// ----------------------------
// 번호, 제목, 등록일, 조회수
// 2, aaa, 2019-1-1, 2
// 1, bbb, 2018-12-31, 3
// ----------------------------
public class Exam0120 {

  public static void main(String[] args) throws Exception {
    try (
        java.sql.Connection con = java.sql.DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        java.sql.Statement stmt = con.createStatement();) {
      java.sql.ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc");
      System.out.println("번호, 제목, 등록일, 조회수");
      while (rs.next()) {
        String str = String.format("%d, %s, %s, %d", rs.getInt("board_id"), rs.getString("title"),
            rs.getDate("created_date"), rs.getInt("view_count"));
        System.out.println(str);
      }

    }

  }
}


