package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateServlet implements Servlet {
  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");
    Member old = memberDao.findByNo(no);
    if (old == null) {
      out.println("해당하는 번호의 회원정보가 없습니다");
      return;
    }
    Member member = new Member();
    member.setNo(old.getNo());
    member.setRegisteredDate(old.getRegisteredDate());
    member.setName(Prompt.getString(in, out, String.format("회원이름(%s)? ", old.getName())));
    member.setEmail(Prompt.getString(in, out, String.format("이메일(%s)? ", old.getEmail())));
    member.setPassword(Prompt.getString(in, out, String.format("암호(%s)? ", old.getPassword())));
    member.setPhoto(Prompt.getString(in, out, String.format("사진(%s)? ", old.getPhoto())));
    member.setTel(Prompt.getString(in, out, String.format("전화(%s)? ", old.getTel())));

    if (memberDao.update(member) > 0) {
      out.println("회원정보를 변경했습니다");
    } else {
      out.println("변경 실패");
    }
  }
}
