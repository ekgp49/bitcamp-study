package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.Prompt;

public class BoardAddCommand implements Command {
  BoardDao boardDao;
  Prompt prompt;

  public BoardAddCommand(BoardDao boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Board board = new Board();

    board.setTitle(prompt.inputString("내용? "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.println("데이터 저장 실패");
    }
  }
}

