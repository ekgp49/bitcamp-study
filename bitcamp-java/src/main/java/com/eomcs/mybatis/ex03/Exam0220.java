// dynamic sql 다루기 - <set> 사용 전 문제점
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0220 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    HashMap<String, Object> params = new HashMap<>();
    params.put("no", 1);

    Scanner keyScan = new Scanner(System.in);
    System.out.print("제목? ");
    String value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }

    System.out.print("내용? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("content", value);
    }

    // dynamic sql을 쓰지 않을 경우
    int count = 0;
    if (params.get("title") != null && params.get("content") != null) {
      count = sqlSession.update("BoardMapper.update3", params);
    } else if (params.get("title") != null) {
      count = sqlSession.update("BoardMapper.update1", params);
    } else if (params.get("content") != null) {
      count = sqlSession.update("BoardMapper.update2", params);
    }
    System.out.println(count);

    // 실무에서는 특정컬럼의 값만 바꾸기 위해 여러개의 sql을 만드는 것은 매우 번거롭다.
    // 그래서 전체 컬럼의 값을 바꾸는 방식을 주로 사용한다.
    // => 성능 떨어짐
    sqlSession.commit();
    sqlSession.close();
    keyScan.close();
  }

}


