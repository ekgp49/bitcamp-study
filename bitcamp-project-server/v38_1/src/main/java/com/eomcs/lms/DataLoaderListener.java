package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;

public class DataLoaderListener implements ApplicationContextListener {
  Connection con;

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");
    try {
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      context.put("boardDao", new BoardDaoImpl(con));
      context.put("lessonDao", new LessonDaoImpl(con));
      context.put("memberDao", new MemberDaoImpl(con));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(con));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");
    try {
      con.close();
    } catch (Exception e) {
      // DB 커넥션을 닫다가 예외 발생하면 무시한다.
      // 클라이언트 쪽에서 달리 해야할 일이 없다.
    }
  }
}
