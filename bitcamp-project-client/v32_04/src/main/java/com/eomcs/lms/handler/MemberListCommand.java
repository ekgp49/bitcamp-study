package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;

  public MemberListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/member/list");
      out.flush();
      // ObjectOutputStream은 내부에 버퍼를 사용한다.
      // 따라서 서버에 즉시 전송하고 싶다면 flush를 명시적으로 호출해야 한다.
      // 참고!
      // close()를 호출해도 자동 flush가 수행된다.
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      List<Member> members = (List<Member>) in.readObject();
      for (Member m : members) {
        System.out.printf("%d, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel(),
            m.getRegisteredDate());
      }
    } catch (Exception e) {
      System.out.println("실행 중 오류 발생");
    }
  }
}
