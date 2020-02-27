package com.eomcs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DataSource {
  String jdbcUrl;
  String username;
  String password;

  // 스레드에 값을 보관하는 일을 할 도구를 준비.
  ThreadLocal<Connection> connectionLocal = new ThreadLocal<>();

  // 반납 받은 커넥션을 보관할 저장소를 준비한다.
  ArrayList<Connection> conList = new ArrayList<>();

  public DataSource(String jdbcUrl, String username, String password) {
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

    // 만약 Connection 객체가 없다면
    // 1. 기존에 반납한 커넥션 객체가 있는지 검사하여 있다면 리턴한다.
    if (conList.size() > 0) {
      con = conList.remove(0); // <<!!!!! 아예 꺼내야 해서 remove 쓰는거임
      System.out.println("기존에 반납받은 객체 재사용");
    } else {
      // 2. 그래도 없다면 새로 만든다.
      con = new ConnectionProxy(DriverManager.getConnection(jdbcUrl, username, password));
      System.out.println("새 객체 생성하여 리턴");
    }

    // 이거 주의: 어디서 꺼내든간에 ThreadLocal 변수에 저장하는건 필수임
    // 리턴하기 전에 스레드에 생성된 Connection 객체의 주소를 기록한다.
    connectionLocal.set(con);
    System.out.printf("DataSource: 현재 보관중인 객체 %d개\n", conList.size());
    return con;
  }

  public Connection removeConnection() {
    // 스레드에 보관된 커넥션 객체를 제거한다.
    // 다음 문장을 실행하는 스레드에서 제거한다.
    Connection con = connectionLocal.get();
    if (con != null) {
      connectionLocal.remove();
      System.out.println("스레드에 보관된 ConnectionProxy 객체 제거됨");

      // 다 쓴 커넥션은 재활용할수 있게 반납한다.
      conList.add(con);
    }
    System.out.printf("DataSource: 현재 보관중인 객체 %d개\n", conList.size());
    return con;
  }

  public void clean() {
    // 리스트에 있는 커넥션 자체도 다 꺼내서 리스트에서 지워버린다. & 꺼낸 모든 커넥션을 닫는다
    while (conList.size() > 0) {
      try {
        ((ConnectionProxy) conList.remove(0)).realclose();
      } catch (Exception e) {
        // 오류 무시
      }
    }

  }
}


