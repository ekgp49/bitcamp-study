package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardUpdateServlet implements Servlet {
  List<Board> boardList;

  public BoardUpdateServlet(List<Board> boardList) {
    this.boardList = boardList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();
    Board board = (Board) in.readObject();
    int index = -1;
    for (int i = 0; i < boardList.size(); i++) {
      if (boardList.get(i).getNo() == no) {
        index = i;
        break;
      }
    }
    boardList.set(index, board);
    out.writeUTF("OK");
  }
}
