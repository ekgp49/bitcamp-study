// Data Persistence Framework 도입 - Mybatis
package com.eomcs.mybatis.ex01;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Data Persistence Framework
// => 데이터의 영속성(지속성; 등록,조회,변경,삭제)을 대신 처리해주는 프레임워크.
// 1) SQL Mapper
// - 직접 SQL 문을 작성
// - 각각의 DBMS에 최적화된 SQL을 작성할 수 있다.
// - DBMS마다 미미하게 다른 SQL을 작성해야 하는 번거로움이 있다.
// - 예) Mybatis 등
// 2) OR Mapper
// - 전용언어 및 문법(Domain-Specific Language;DSL)을 사용하여 작성
// 실행할 때 DBMS에 맞춰서 SQL을 생성하여 실행한다.
// - DBMS에 마다 SQL문을 작성할 필요가 없어 편리하다.
// - 단, DBMS에 최적화된 SQL을 실행할 수 없다.
// 즉 DBMS의 특징을 최대로 활용할 수 없다.
// - 예) Hibernate, TopLink 등
//
// Mybatis 도입
// 1) 의존 라이브러리 추가
// - mvnrepository.com 검색하여 build.gradle 파일에 추가한다.
// - "gradle eclipse" 실행한 후 이클립스 에디터에서 프로젝트를 "refresh" 한다.
// 2) mybatis 설정 파일 준비
// - mybatis-config.xml 생성 및 편집
// 3) DB 연결 정보를 담은 프로퍼티 파일 준비
// - jdbc.properties 생성 및 편집
// 4) SQL 문장을 작성할 파일 준비
// - BoardMapper.xml 생성 및 편집
// 5) Mybatis 객체 준비
//
public class Exam0111 {

  public static void main(String[] args) throws Exception {
    // mybatis 설정 파일을 읽을 inputStream도구를 준비한다.
    // 1) 직접 파일 시스템 경로를 지정하기
    // => 다음과같이 설정파일의 경로를 직접 지정하면
    // 애플리케이션 배포 경로가 바뀔때마다 소스를 변경하고 다시 컴파일해야하는 문제가 있다.
    // InputStream inputStream =
    // new FileInputStream("./bin/main/com/eomcs/mybatis/ex01/mybatis-config.xml");

    // => 그래서 mybatis는 도우미 객체를 제공한다.
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex01/mybatis-config.xml");

    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    System.out.println("mybatis 준비 완료!");

    sqlSession.close();
  }

}


