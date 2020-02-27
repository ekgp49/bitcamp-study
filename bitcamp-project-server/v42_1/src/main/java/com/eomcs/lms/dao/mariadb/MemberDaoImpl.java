package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.sql.DataSource;

public class MemberDaoImpl implements MemberDao {
  DataSource dataSource;

  public MemberDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public List<Member> findAll() throws Exception {
    try (Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt
            .executeQuery("select member_id, name, email, pwd, photo, tel, cdt from lms_member")) {

      ArrayList<Member> list = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        list.add(member);
      }
      return list;
    }
  }

  @Override
  public int insert(Member member) throws Exception {
    try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("insert into lms_member(name, email, pwd, photo, tel) values('"
          + member.getName() + "', '" + member.getEmail() + "', password('" + member.getPassword()
          + "'), '" + member.getPhoto() + "', '" + member.getTel() + "')");
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select member_id, name, email, pwd, photo, tel, cdt from lms_member where member_id="
                + no)) {
      if (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setRegisteredDate(rs.getDate("cdt"));
        member.setPassword(rs.getString("pwd"));
        member.setEmail(rs.getString("email"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        return member;
      } else {
        return null;
      }
    }
  }

  @Override
  public int update(Member member) throws Exception {
    try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("update lms_member set name = '" + member.getName() + "', email = '"
          + member.getEmail() + "', pwd = password('" + member.getPassword() + "'), " + "photo = '"
          + member.getPhoto() + "', tel = '" + member.getPassword() + "' " + "where member_id="
          + member.getNo());
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = dataSource.getConnection(); Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("delete from lms_member where member_id=" + no);
    }
  }

  @Override
  public List<Member> findByKeyword(String keyword) throws Exception {
    try (Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs =
            stmt.executeQuery("select member_id, name, email, pwd, photo, tel, cdt from lms_member"
                + " where name like '%" + keyword + "%'" + " or email like '%" + keyword + "%'"
                + " or tel like '%" + keyword + "%'"/* 통합 검색 */)) {

      ArrayList<Member> list = new ArrayList<>();
      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        list.add(member);
      }
      return list;
    }
  }

  @Override
  public Member findByEmailAndPassword(String email, String password) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con
            .prepareStatement("select * from lms_member where email = ? and pwd = password(?)")) {
      stmt.setString(1, email);
      stmt.setString(2, password);
      try (ResultSet rs = stmt.executeQuery()) {
        rs.next();
        Member member = new Member();
        member.setNo(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setPassword(rs.getString("pwd"));
        member.setPhoto(rs.getString("photo"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(rs.getDate("cdt"));
        return member;
      }
    }
  }

}
