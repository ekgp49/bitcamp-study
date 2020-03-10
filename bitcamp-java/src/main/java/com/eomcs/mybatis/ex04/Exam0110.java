// Mybatis - 자바 객체의 프로퍼티 이름과 컬럼명을 일치시키기 II
package com.eomcs.mybatis.ex04;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex04/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // Board board = sqlSession.selectOne("BoardMapper.selectBoard");
    // select 결과는 여러개인데 하나만 리턴받으려고 하니까 오류남
    Board board = sqlSession.selectOne("BoardMapper.selectBoard", 1);

    System.out.println("[게시글 조회]");
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.println();

    // 조인을 사용하지 않으면 다음과 같이 게시글의 첨부 파일 데이터를 따로 조회해야 한다.

    List<AttachFile> attachFile = sqlSession.selectList("BoardMapper.selectFile", 1);
    System.out.println("[첨부파일]");
    for (AttachFile file : attachFile) {
      System.out.printf("%d, %s\n", file.getNo(), file.getFilePath());
    }

    sqlSession.close();
  }

}


