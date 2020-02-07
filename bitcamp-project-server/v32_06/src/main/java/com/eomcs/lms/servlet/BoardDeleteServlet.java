package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDeleteServlet implements Servlet {
  List<Board> boardList;

  public BoardDeleteServlet(List<Board> boardList) {
    this.boardList = boardList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    int index = -1;
    for (int i = 0; i < boardList.size(); i++) {
      if (boardList.get(i).getNo() == no) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 게시물이 없습니다.");
    } else {
      out.writeUTF("OK");
      boardList.remove(index);
      out.writeUTF("게시글을 삭제했습니다.");
    }
  }
}
