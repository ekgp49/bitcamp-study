package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberListCommand implements Command {
  List<Member> memberList;
  Prompt prompt;

  public MemberListCommand(List<Member> list) {
    // List 파라미터는 List 인터페이스를 구현한 객체를 받는다.
    this.memberList = list;
  }

  @Override
  public void execute() {
    Iterator<Member> iterator = memberList.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel(),
          m.getRegisteredDate());
    }
  }
}
