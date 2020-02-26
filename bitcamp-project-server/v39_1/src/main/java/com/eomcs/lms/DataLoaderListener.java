package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;

public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");
    try {
      // DB 연결 정보
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String username = "study";
      String password = "1111";

      context.put("boardDao", new BoardDaoImpl(jdbcUrl, username, password));
      context.put("lessonDao", new LessonDaoImpl(jdbcUrl, username, password));
      context.put("memberDao", new MemberDaoImpl(jdbcUrl, username, password));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(jdbcUrl, username, password));
      context.put("photoFileDao", new PhotoFileDaoImpl(jdbcUrl, username, password));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");
  }
}
