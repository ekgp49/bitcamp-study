// 서블릿 초기화 파라미터 - 애노테이션으로 설정하기
package com.eomcs.web.ex06;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

// 서블릿이 사용할 값을 DD 설정으로 지정할 수 있다.
//
@WebServlet(value = "/ex06/s3", loadOnStartup = 1,
    initParams = {@WebInitParam(name = "jdbc.driver", value = "org.mariadb.jdbc.Driver"),
        @WebInitParam(name = "jdbc.url", value = "jdbc:mariadb://localhost/studydb"),
        @WebInitParam(name = "jdbc.username", value = "study"),
        @WebInitParam(name = "jdbc.password", value = "1111")})
@SuppressWarnings("serial")
public class Servlet03 extends HttpServlet {

  // @Override
  // public void init(ServletConfig config) throws ServletException {
  // // 서블릿 객체가 생성될때 뭔가 준비하는 작업을 해야 한다면
  // // 보통 이 메서드를 오버라이딩한다.
  // // 문제는 이 메서드가 호출될 때 넘어오는 값(ServletConfig)을 인스턴스 필드에 보관했다가
  // // 나중에 getServletConfig()가 호출될 때 리턴해줘야 할 코드를 추가해야 한다.
  // // 이런 작업이 번거롭다.
  // // 이런 불편함을 없애기 위해서 GenericServlet은 미리 이 메서드의 해당코드를 작성해두었다.
  // // 그리고 추가적으로 파라미터 값을 받지 않는 init()를 호출하도록 구현하였다.
  //
  // // 결론: 그러니 개발자는 servlet객체가 생성될 때 뭔가 작업을 수행하고 싶다면 이 메서드를 직접
  // // 오버라이딩하지 말고 이 메서드가 호출하는 다른 init()를 오버라이딩하라
  // super.init(config);
  // }

  @Override
  public void init() throws ServletException {
    System.out.println("/ex06/s3 => init()");
    // 이 객체가 생성될때 DB에 연결된다고 가정하자.
    // DB에 연결하려만 JDBC Driver 이름과 JDBC url, 사용자아이디, 암호를 알아야 한다.
    // 그런데 다음과 같이 자바 소스코드에 그 값을 직접 작성하면 나중에 DB연결 정보가
    // 바뀌었을때 이 소스를 변경하고 다시 컴파일해야하는 번거로움이 있다.
    // => 소스에 가변값을 작성하는 것은 바람직하지 않다.
    // 보통 이렇게 작성하는 것을 "하드코딩"이라 부른다.
    // String jdbcDriver = "org.mariadb.jdbcdriver.Driver";
    // String jdbcUrl = "jdbc:maraidb://localhost:3306/studydb";
    // String username = "study";
    // String password = "1111";
    ServletConfig config = this.getServletConfig();

    String jdbcDriver = config.getInitParameter("jdbc.driver");
    String jdbcUrl = config.getInitParameter("jdbc.url");
    String username = config.getInitParameter("jdbc.username");
    String password = config.getInitParameter("jdbc.password");

    System.out.println(jdbcDriver);
    System.out.println(jdbcUrl);
    System.out.println(username);
    System.out.println(password);
  }
}

