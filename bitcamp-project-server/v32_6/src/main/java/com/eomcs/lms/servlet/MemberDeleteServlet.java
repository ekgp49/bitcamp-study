package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberDeleteServlet implements Servlet {
  List<Member> memberList;

  public MemberDeleteServlet(List<Member> memberList) {
    this.memberList = memberList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    int index = -1;
    for (int i = 0; i < memberList.size(); i++) {
      if (memberList.get(i).getNo() == no) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 회원정보이 없습니다.");
    } else {
      out.writeUTF("OK");
      memberList.remove(index);
      out.writeUTF("회원정보를 삭제했습니다.");
    }
  }
}
