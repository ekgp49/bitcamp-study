package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListServlet implements Servlet {
  List<Board> boardList;

  public BoardListServlet(List<Board> boardList) {
    this.boardList = boardList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.reset();
    out.writeObject(boardList);
  }
}
