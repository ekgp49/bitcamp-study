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
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;

public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");
    try {
      // Mybatis 객체 준비.
      InputStream inputStream =
          Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder().build(inputStream));

      context.put("boardDao", new BoardDaoImpl(sqlSessionFactory));
      context.put("lessonDao", new LessonDaoImpl(sqlSessionFactory));
      context.put("memberDao", new MemberDaoImpl(sqlSessionFactory));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(sqlSessionFactory));
      context.put("photoFileDao", new PhotoFileDaoImpl(sqlSessionFactory));

      // 트랜잭션 관리자 준비
      context.put("transactionManager", new PlatformTransactionManager(sqlSessionFactory));
      context.put("sqlSessionFactory", sqlSessionFactory);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");
  }
}
