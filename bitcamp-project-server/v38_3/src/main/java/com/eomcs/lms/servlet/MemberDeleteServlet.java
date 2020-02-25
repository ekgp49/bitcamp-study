package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.util.Prompt;

public class MemberDeleteServlet implements Servlet {
  MemberDao memberDao;

  public MemberDeleteServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    int no = Prompt.getInt(in, out, "번호? ");

    if (memberDao.delete(no) > 0) {
      out.println("회원정보를 삭제했습니다.");
    } else {
      out.println("해당번호의 회원정보가 없습니다.");
    }
  }
}
