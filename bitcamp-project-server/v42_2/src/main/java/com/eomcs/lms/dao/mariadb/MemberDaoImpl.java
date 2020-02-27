package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        PreparedStatement stmt = con.prepareStatement(
            "select member_id, name, email, pwd, photo, tel, cdt from lms_member");
        ResultSet rs = stmt.executeQuery()) {

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
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "insert into lms_member(name, email, pwd, photo, tel) values(?, ?, password(?), ?, ?)")) {
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getPhoto());
      stmt.setString(5, member.getTel());

      return stmt.executeUpdate();
    }
  }

  @Override
  public Member findByNo(int no) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt =
            con.prepareStatement("select member_id, name, email, pwd, photo, tel, cdt"//
                + " from lms_member where member_id=?")) {
      stmt.setInt(1, no);
      try (ResultSet rs = stmt.executeQuery()) {
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
  }

  @Override
  public int update(Member member) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(//
            "update lms_member"//
                + " set name = ?, email = ?, pwd = password(?), photo = ?, tel = ?"//
                + " where member_id=?")) {
      stmt.setString(1, member.getName());
      stmt.setString(2, member.getEmail());
      stmt.setString(3, member.getPassword());
      stmt.setString(4, member.getPhoto());
      stmt.setString(5, member.getTel());
      stmt.setInt(6, member.getNo());
      return stmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from lms_member where member_id=?")) {
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }

  @Override
  public List<Member> findByKeyword(String keyword) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(//
            "select member_id, name, email, pwd, photo, tel, cdt from lms_member"
                + " where name like ?"//
                + " or email like ?"//
                + " or tel like concat('%',?,'%')")) {
      String str = "%" + keyword + "%";
      stmt.setString(1, str);
      stmt.setString(2, str);
      stmt.setString(3, keyword);

      try (ResultSet rs = stmt.executeQuery()) {
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

  }

  @Override
  public Member findByEmailAndPassword(String email, String password) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con
            .prepareStatement("select * from lms_member where email = ? and pwd = password(?)")) {
      stmt.setString(1, email);
      stmt.setString(2, password);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_id"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPassword(rs.getString("pwd"));
          member.setPhoto(rs.getString("photo"));
          member.setTel(rs.getString("tel"));
          member.setRegisteredDate(rs.getDate("cdt"));
          return member;
        } else {
          return null;
        }
      }
    }
  }

}
