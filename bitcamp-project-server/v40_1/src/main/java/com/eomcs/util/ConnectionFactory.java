package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
  String jdbcUrl;
  String username;
  String password;

  // 스레드에 값을 보관하는 일을 할 도구를 준비.
  ThreadLocal<Connection> connectionLocal = new ThreadLocal<>();

  public ConnectionFactory(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception {
    // 먼저 스레드에 Connection 객체가 보관되어 있는지 알아본다.
    Connection con = connectionLocal.get();
    if (con != null) {
      System.out.println("스레드에 보관된 커넥션 객체 리턴");
      return con;
    }

    // 만약 Connection 객체가 없다면 새로 만든다.
    con = DriverManager.getConnection(jdbcUrl, username, password);
    System.out.println("새 커넥션 객체 생성하여 리턴");
    // 리턴하기 전에 스레드에 생성된 Connection 객체의 주소를 기록한다.
    connectionLocal.set(con);
    return con;
  }

  public void removeConnection() {
    // 스레드에 보관된 커넥션 객체를 제거한다.
    // 다음 문장을 실행하는 스레드에서 제거한다.
    Connection con = connectionLocal.get();
    if (con != null) {
      connectionLocal.remove();
    }
  }
}
