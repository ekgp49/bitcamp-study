package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberAddServlet {

  MemberService memberService;

  public MemberAddServlet(MemberService memberService) {
    this.memberService = memberService;
  }


  @RequestMapping("/member/add")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    Member member = new Member();
    for (Field field : Member.class.getDeclaredFields()) {
      for (String key : params.keySet()) {
        if (field.getName().equals(key)) {
          for (Method method : Member.class.getDeclaredMethods()) {
            if (method.getName().startsWith("set")
                && method.getName().toLowerCase().endsWith(key.toLowerCase())) {
              if (field.getType() == String.class) {
                method.setAccessible(true);
                method.invoke(member, params.get(key));
              } else if (field.getType() == int.class) {
                method.setAccessible(true);
                method.invoke(member, Integer.parseInt(params.get(key)));
              } else if (field.getType() == java.sql.Date.class) {
                method.setAccessible(true);
                method.invoke(member, Date.valueOf(params.get(key)));
              }
            }
          }
        }
      }
    }

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/member/list'>");
    out.println("<title>회원 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 등록</h1>");
    if (memberService.add(member) > 0) {
      out.println("회원을 등록했습니다.");
    } else {
      out.println("저장에 실패했습니다.");
    }
    out.println("</body>");
    out.println("</html>");

  }
}
