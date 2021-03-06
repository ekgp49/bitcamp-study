package com.eomcs.lms;

import java.io.InputStream;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;
import com.eomcs.sql.DataSource;
import com.eomcs.sql.PlatformTransactionManager;

public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");
    try {
      // DB 연결 정보
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String username = "study";
      String password = "1111";

      // ConnectionFactory 준비
      DataSource dataSource = new DataSource(jdbcUrl, username, password);
      context.put("dataSource", dataSource);

      // Mybatis 객체 준비.
      InputStream inputStream =
          Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      context.put("boardDao", new BoardDaoImpl(dataSource, sqlSessionFactory));
      context.put("lessonDao", new LessonDaoImpl(dataSource, sqlSessionFactory));
      context.put("memberDao", new MemberDaoImpl(dataSource, sqlSessionFactory));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(dataSource, sqlSessionFactory));
      context.put("photoFileDao", new PhotoFileDaoImpl(dataSource, sqlSessionFactory));

      // 트랜잭션 관리자 준비
      context.put("transactionManager", new PlatformTransactionManager(dataSource));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    DataSource dataSource = (DataSource) context.get("dataSource");
    dataSource.clean();
    System.out.println("데이터를 저장합니다.");
  }
}
