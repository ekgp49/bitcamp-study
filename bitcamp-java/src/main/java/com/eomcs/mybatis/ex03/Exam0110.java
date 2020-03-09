// dynamic sql 다루기 - 조건문 적용 전
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // dynamic sql?
    // 조건문에 따라 sql을 달리 생성하는 것
    // mybatis는 조건에 따라 sql을 변경하거나
    // 동일한 sql을 반복적으로 생성할 수 있는 문법을 제공한다.

    // 사용자에게 번호를 입력받아 조회.
    // 오류발생시 전체 게시글 출력

    Scanner keyScan = new Scanner(System.in);
    System.out.print("게시글 번호? ");
    String str = keyScan.nextLine();

    List<Board> list = null;

    try {
      list = sqlSession.selectList("BoardMapper.select1", Integer.parseInt(str));
    } catch (Exception e) {
      // 예외뜨면 (숫자 아니고 이상한거 입력) 리스트 전체 출력
      list = sqlSession.selectList("BoardMapper.select2");
    }

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getRegisteredDate(), board.getViewCount());
    }

    sqlSession.close();
    keyScan.close();
  }

}


