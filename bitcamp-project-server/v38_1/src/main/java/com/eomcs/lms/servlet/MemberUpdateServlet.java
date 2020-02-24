package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {
  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    int no = Integer.parseInt(in.nextLine());
    Member old = memberDao.findByNo(no);
    if (old == null) {
      out.println("해당하는 번호의 회원정보가 없습니다");
      return;
    }
    Member member = new Member();
    member.setNo(old.getNo());
    member.setRegisteredDate(old.getRegisteredDate());
    out.printf("회원이름(%s)? \n!{}!\n", old.getName());
    member.setName(in.nextLine());
    out.printf("이메일(%s)? \n!{}!\n", old.getEmail());
    member.setEmail(in.nextLine());
    out.printf("암호(%s)? \n!{}!\n", old.getPassword());
    member.setPassword(in.nextLine());
    out.printf("사진(%s)? \n!{}!\n", old.getPhoto());
    member.setPhoto(in.nextLine());
    out.printf("전화(%s)? \n!{}!\n", old.getTel());
    member.setTel(in.nextLine());


    if (memberDao.update(member) > 0) {
      out.println("회원정보를 변경했습니다");
    } else {
      out.println("변경 실패");
    }
  }
}
