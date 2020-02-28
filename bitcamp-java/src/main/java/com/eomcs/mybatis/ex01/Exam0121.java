// Mybatis - SQL 문 실행
package com.eomcs.mybatis.ex01;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0121 {

  public static void main(String[] args) throws Exception {
    SqlSessionFactory factory = new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("com/eomcs/mybatis/ex01/mybatis-config.xml"));
    SqlSession sqlSession = factory.openSession();

    List<Board> list = sqlSession.selectList("BoardMapper2.selectBoard");

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate(), board.getViewCount());
    }

    sqlSession.close();
  }

}


