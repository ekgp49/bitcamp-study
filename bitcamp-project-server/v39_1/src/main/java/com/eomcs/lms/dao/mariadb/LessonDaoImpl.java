package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl implements LessonDao {
  String jdbcUrl;
  String username;
  String password;

  public LessonDaoImpl(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  @Override
  public List<Lesson> findAll() throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson")) {

      ArrayList<Lesson> list = new ArrayList<>();
      while (rs.next()) {
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setStartDate(rs.getDate("sdt"));
        lesson.setEndDate(rs.getDate("edt"));
        lesson.setTotalHours(rs.getInt("tot_hr"));
        lesson.setDayHours(rs.getInt("day_hr"));
        lesson.setTitle(rs.getString("titl"));
        lesson.setDescription(rs.getString("conts"));
        list.add(lesson);
      }
      return list;
    }
  }

  @Override
  public int insert(Lesson lesson) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("insert into lms_lesson(sdt, edt, tot_hr, day_hr, titl, conts)"
          + " values('" + lesson.getStartDate() + "', '" + lesson.getEndDate() + "', '"
          + lesson.getTotalHours() + "', " + "'" + lesson.getDayHours() + "', '" + lesson.getTitle()
          + "', '" + lesson.getDescription() + "')");
    }
  }

  @Override
  public Lesson findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery( //
            "select lesson_id, titl, conts, sdt, edt, tot_hr, day_hr" + " from lms_lesson"
                + " where lesson_id=" + no)) {

      if (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setTitle(rs.getString("titl"));
        lesson.setDescription(rs.getString("conts"));
        lesson.setStartDate(rs.getDate("sdt"));
        lesson.setEndDate(rs.getDate("edt"));
        lesson.setTotalHours(rs.getInt("tot_hr"));
        lesson.setDayHours(rs.getInt("day_hr"));
        return lesson;

      } else {
        return null;
      }
    }
  }


  @Override
  public int update(Lesson lesson) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("update lms_lesson set" //
          + " titl='" + lesson.getTitle() //
          + "', conts='" + lesson.getDescription() //
          + "', sdt='" + lesson.getStartDate() //
          + "', edt='" + lesson.getEndDate() //
          + "', tot_hr=" + lesson.getTotalHours() //
          + ", day_hr=" + lesson.getDayHours() //
          + " where lesson_id=" + lesson.getNo());
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("delete from lms_lesson where lesson_id=" + no);
    }
  }

}
