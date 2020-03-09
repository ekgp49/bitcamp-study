// dynamic sql 다루기 - <foreach> 사용 후
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0260 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);
    System.out.print("조회할 게시물 번호들(예: 1 6 8 10)? ");
    String[] values = keyScan.nextLine().split(" ");

    keyScan.close();

    ArrayList<Object> noList = new ArrayList<>();
    for (String value : values) {
      noList.add(value);
    }
    params.put("noList", noList);

    List<Board> list = sqlSession.selectList("BoardMapper.select24", params);

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate(), board.getViewCount());
    }

    sqlSession.close();
  }

}


