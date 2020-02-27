package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class LoginServlet implements Servlet {
  MemberDao memberDao;

  public LoginServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    String email = Prompt.getString(in, out, "이메일? ");
    String password = Prompt.getString(in, out, "암호? ");
    try {
      Member member = memberDao.findByEmailAndPassword(email, password);
      out.printf("%s님 환영합니다\n", member.getName());
    } catch (Exception e) {
      out.println("사용자 정보가 유효하지 않습니다.\n");
    }
  }
}
