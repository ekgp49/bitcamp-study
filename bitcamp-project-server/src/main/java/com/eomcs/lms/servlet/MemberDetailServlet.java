package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;


@Component
public class MemberDetailServlet {

  MemberService memberService;

  public MemberDetailServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/detail")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int no = Integer.parseInt(params.get("no"));
    Member member = memberService.get(no);
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 정보</h1>");
    if (member != null) {
      out.printf("<p>번호: %d</p>\n", member.getNo());
      out.printf("<p>이름: %s</p>\n", member.getName());
      out.printf("<p>이메일: %s</p>\n", member.getEmail());
      out.printf("<p>사진: %s</p>\n", member.getPhoto());
      out.printf("<p>전화번호: %s</p>\n", member.getTel());
      out.printf("<p>등록일: %s</p>\n", member.getRegisteredDate());
      out.printf("<p><a href='/member/delete?no=%d'>삭제</a>\n", member.getNo());
      out.printf("<a href='/member/updateForm?no=%d'>변경</a>\n", member.getNo());
    } else {
      out.println("<p>해당 번호의 회원이 없습니다.</p>\n");
    }
    out.println("<p><a href='/member/list'>회원 리스트</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
