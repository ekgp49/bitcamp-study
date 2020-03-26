package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberUpdateFormServlet {

  MemberService memberService;

  public MemberUpdateFormServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/updateForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    Member member = memberService.get(Integer.parseInt(params.get("no")));
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 정보 수정</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 정보 수정</h1>");
    out.println("<form action='/member/update'>");
    out.printf("회원번호: <input name='no' readonly type='text' value='%d'><br>\n", member.getNo());
    out.println("이름: <input name='title' type='text'><br>\n");
    out.println("이메일: <input name='email' type='text'><br/>\n");
    out.println("사진: <input name='photo' type='text'><br>\n");
    out.println("전화번호: <input name='tel' type='text'><br>\n");
    out.println("비밀번호: <input name='password' type='text'><br>\n");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}
