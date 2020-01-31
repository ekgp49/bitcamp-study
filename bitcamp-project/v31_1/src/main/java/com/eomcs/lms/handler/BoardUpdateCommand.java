package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardUpdateCommand implements Command {
  Prompt prompt;
  List<Board> boardList;

  public BoardUpdateCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }

  @Override
  public void execute() {
    int index = indexOfBoard(prompt.inputInt("게시물 번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Board oldBoard = this.boardList.get(index);

    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setTitle(
        prompt.inputString(String.format("내용(%s)? ", oldBoard.getTitle()), oldBoard.getTitle()));
    newBoard.setDate(oldBoard.getDate());
    newBoard.setViewCount(oldBoard.getViewCount());

    if (!newBoard.equals(oldBoard)) {
      this.boardList.set(index, newBoard);
      System.out.println("게시글을 변경했습니다.");
    } else {
      System.out.println("게시글 변경을 취소했습니다.");
    }
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
