package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.json.MemberJsonFileDao;

public class MemberDeleteServlet implements Servlet {
  MemberJsonFileDao memberDao;

  public MemberDeleteServlet(MemberJsonFileDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    if (memberDao.delete(no) > 0) {
      out.writeUTF("OK");
      out.writeUTF("회원정보를 삭제했습니다.");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 회원정보이 없습니다.");
    }
  }
}
