// 게시판 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
package com.eomcs.jdbc.ex3;

import java.util.Scanner;

public class Exam0110 {

  public static void main(String[] args) throws Exception {

    Board board = new Board();

    try (Scanner keyScan = new Scanner(System.in)) {

      // 사용자로부터 제목, 내용을 입력 받는다.
      System.out.print("제목? ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용? ");
      board.setContent(keyScan.nextLine());

      System.out.print("입력하시겠습니까?(Y/n) ");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소 하였습니다.");
        return;
      }
    }

    try {
      BoardDao boardDao = new BoardDao();
      int count = boardDao.insert(board);
      System.out.printf("%d 개 입력 성공!", count);

      // 이렇게 DBMS 작업을 별도의 클래스로 분리하여 캡슐화하면
      // 데이터 처리를 요구하는 쪽에서는
      // 데이터의 구체적인 처리방식을 몰라도 되기 때문에
      // 코드가 간결해진다.
      // 또한 데이터 처리 방식이 바뀌더라도 영향을 받지 않는다.
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


