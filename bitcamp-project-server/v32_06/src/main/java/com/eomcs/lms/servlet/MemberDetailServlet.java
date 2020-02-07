package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDetailServlet implements Servlet {
  List<Member> memberList;

  public MemberDetailServlet(List<Member> memberList) {
    this.memberList = memberList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    Member member = null;
    for (Member b : memberList) {
      if (b.getNo() == no) {
        member = b;
      }
    }
    if (member == null) {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 회원정보이 없습니다.");
    } else {
      out.writeUTF("OK");
      out.writeObject(member);
    }
  }
}
