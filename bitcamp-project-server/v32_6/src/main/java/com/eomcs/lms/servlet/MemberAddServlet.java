package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberAddServlet implements Servlet {
  List<Member> memberList;

  public MemberAddServlet(List<Member> memberList) {
    this.memberList = memberList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      Member member = (Member) in.readObject();
      memberList.add(member);
      System.out.println("회원정보를 저장했습니다.");
      out.writeUTF("OK");
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
