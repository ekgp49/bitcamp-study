package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberListServlet {

  MemberService memberService;

  public MemberListServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    out.printf("<!DOCTYPE html>");
    out.printf("<html>");
    out.printf("<head>");
    out.printf("<meta charset='UTF-8'>");
    out.printf("<title>회원 리스트</title>");
    out.printf("</head>");
    out.printf("<body>");
    out.printf("<h1>회원 리스트</h1>");
    out.println("<a href='/member/addForm'>새 회원 등록하기</a>");
    out.printf("<table border='5'>");
    out.printf("<tr><th>번호</th><th>이름</th><th>이메일</th><th>사진</th>"//
        + "<th>전화번호</th><th>등록일</th></tr>");
    List<Member> members = memberService.list();
    for (Member m : members) {
      System.out.println(m);
      out.printf("<tr><td>%d</td> "//
          + "<td><a href='/member/detail?no=%d'>%s</td> "//
          + "<td>%s</td> "//
          + "<td>%s</td> "//
          + "<td>%s</td> "//
          + "<td>%s</td></tr>\n", //
          m.getNo(), m.getNo(), m.getName(), m.getEmail(), m.getPhoto(), m.getTel(),
          m.getRegisteredDate());
    }
    out.printf("</table>");
    out.printf("</body>");
    out.printf("</html>");
  }
}
