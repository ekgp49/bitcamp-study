package com.eomcs.lms.handler;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.util.Prompt;

public class MemberDeleteCommand implements Command {
  MemberDao memberDao;
  Prompt prompt;

  public MemberDeleteCommand(MemberDao memberDao, Prompt prompt) {
    this.memberDao = memberDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");
      if (memberDao.delete(no) > 0) {
        System.out.println("삭제했습니다");
      } else {
        System.out.println("해당 번호 회원이 없습니다");
      }
    } catch (Exception e) {
      System.out.println("삭제 실패");
    }
  }
}
