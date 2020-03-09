// dynamic sql 다루기 - 조건문 적용
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    Scanner keyScan = new Scanner(System.in);
    System.out.print("게시글 번호? ");
    String str = keyScan.nextLine();

    List<Board> list = null;

    try {
      list = sqlSession.selectList("BoardMapper.select3", Integer.parseInt(str));
    } catch (Exception e) {
      e.printStackTrace();
      // 게시글 번호가 없거나 예외가 발생하면 게시물 전체 출력
      list = sqlSession.selectList("BoardMapper.select3");
    }
    // 이 때 같은 sql문(select3)을 실행한다.
    // 조건에 따라 여러 sql문을 생성할 필요가없어 편리하다.
    // 다만 sql문을 작성하는데 복잡하다.

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %d\n", board.getNo(), board.getTitle(),
          board.getRegisteredDate(), board.getViewCount());
    }

    sqlSession.close();
    keyScan.close();
  }

}


