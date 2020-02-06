package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.MemberObjectFileDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {
  MemberObjectFileDao memberDao;

  public MemberUpdateServlet(MemberObjectFileDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Member member = (Member) in.readObject();
    if (memberDao.update(member) > 0) {
      out.writeUTF("OK");
      out.writeUTF("회원정보를 수정했습니다");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당하는 번호의 회원정보가 없습니다");
    }
  }
}
