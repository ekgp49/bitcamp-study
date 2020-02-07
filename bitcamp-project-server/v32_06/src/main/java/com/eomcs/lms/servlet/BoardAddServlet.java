package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardAddServlet implements Servlet {
  List<Board> boardList;

  public BoardAddServlet(List<Board> boardList) {
    this.boardList = boardList;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      Board board = (Board) in.readObject();
      boardList.add(board);
      System.out.println("게시물을 저장했습니다.");
      out.writeUTF("OK");
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
