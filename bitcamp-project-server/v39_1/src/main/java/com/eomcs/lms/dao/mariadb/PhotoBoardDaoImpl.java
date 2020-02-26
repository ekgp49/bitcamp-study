package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {
  String jdbcUrl;
  String username;
  String password;

  public PhotoBoardDaoImpl(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }


  @Override
  public List<PhotoBoard> findAllByLessonNo(int lessonNo) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "select photo_id, titl, cdt, vw_cnt, lesson_id" //
                + " from lms_photo" //
                + " where lesson_id=" + lessonNo //
                + " order by photo_id desc")) {

      ArrayList<PhotoBoard> list = new ArrayList<>();

      while (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();

        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreatedDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        list.add(photoBoard);
      }

      return list;
    }
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate(
          "insert into lms_photo(titl, lesson_id) values('" + photoBoard.getTitle() + "', '"
              + photoBoard.getLesson().getNo() + "' )",
          Statement.RETURN_GENERATED_KEYS /* insert 한 후에 pk값 리턴받기 */);

      // auto-increment pk값을 꺼내기 위한 준비를 한다.
      try (ResultSet generatedKeySet = stmt.getGeneratedKeys()) {
        generatedKeySet.next(); // 값 가져오기
        photoBoard.setNo(generatedKeySet.getInt(1)); // 값 꺼내기
      }
      return result;
    }
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(//
            "select" //
                + " p.photo_id," //
                + " p.titl photo_title," //
                + " p.cdt," //
                + " p.vw_cnt," //
                + " l.lesson_id," //
                + " l.titl lesson_title" //
                + " from lms_photo p" //
                + " inner join lms_lesson l on p.lesson_id = l.lesson_id where photo_id=" + no)) {

      if (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("photo_title"));
        photoBoard.setCreatedDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setTitle(rs.getString("lesson_title"));
        photoBoard.setLesson(lesson);
        return photoBoard;
      } else {
        return null;
      }
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("update lms_photo set titl = '" + photoBoard.getTitle()
          + "' where photo_id=" + photoBoard.getNo());
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("delete from lms_photo where photo_id=" + no);
    }
  }

}
