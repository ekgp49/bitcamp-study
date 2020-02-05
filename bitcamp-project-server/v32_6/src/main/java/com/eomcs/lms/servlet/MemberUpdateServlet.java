package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {
  List<Member> memberList;

  public MemberUpdateServlet(List<Member> memberList) {
    this.memberList = memberList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    Member member = (Member) in.readObject();
    int index = -1;
    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getNo() == no) {
        index = i;
        break;
      }
    }
    memberList.set(index, member);
    out.writeUTF("OK");
  }
}
