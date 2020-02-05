package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;

  public BoardListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/board/list");
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
      List<Board> boards = (List<Board>) in.readObject();
      for (Board b : boards) {
        System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(),
            b.getViewCount());
      }
    } catch (Exception e) {
      System.out.println("실행 중 오류 발생");
    }
  }
}
