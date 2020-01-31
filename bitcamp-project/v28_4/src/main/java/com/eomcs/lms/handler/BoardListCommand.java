package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  List<Board> boardList;

  public BoardListCommand(List<Board> list) {
    this.boardList = list;
  }

  @Override
  public void execute() {
    Iterator<Board> list = boardList.iterator();
    while (list.hasNext()) {
      Board b = list.next();
      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }
}
