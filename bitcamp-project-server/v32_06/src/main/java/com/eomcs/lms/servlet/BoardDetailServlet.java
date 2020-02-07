package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDetailServlet implements Servlet {
  List<Board> boardList;

  public BoardDetailServlet(List<Board> boardList) {
    this.boardList = boardList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    Board board = null;
    for (Board b : boardList) {
      if (b.getNo() == no) {
        board = b;
      }
    }
    if (board == null) {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 게시물이 없습니다.");
    } else {
      out.writeUTF("OK");
      out.writeObject(board);
    }
  }
}
