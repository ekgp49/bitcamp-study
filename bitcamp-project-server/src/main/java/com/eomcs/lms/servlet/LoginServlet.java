package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class LoginServlet {

  MemberService memberService;

  public LoginServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/auth/login")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.printf("<!DOCTYPE html>");
    out.printf("<html>");
    out.printf("<head>");
    out.printf("<meta charset='UTF-8'>");
    out.printf("<title>로그인</title>");
    out.printf("</head>");
    out.printf("<body>");
    out.printf("<h1>로그인</h1>");

    String email = params.get("email");
    String password = params.get("password");

    HashMap<String, Object> parameter = new HashMap<>();
    parameter.put("email", email);
    parameter.put("password", password);

    Member member = memberService.get(parameter);

    if (member != null) {
      out.printf("<p>'%s'님 환영합니다.</p>\n", member.getName());
      out.println("<a href='/board/list'>게시글리스트 가기<br></a>\n");
      out.println("<a href='/lesson/list'>레슨리스트 가기</a><br>\n");
      out.println("<a href='/member/list'>회원리스트 가기</a><br>\n");
    } else {
      out.println("<p>사용자 정보가 유효하지 않습니다.</p>\n");
      out.println("<a href='/auth/loginForm'>로그인페이지로 돌아가기</a>\n");
    }
    out.printf("</body>");
    out.printf("</html>");

  }
}
