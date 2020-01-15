package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;

public class BoardHandler {
  Prompt prompt;
  // 목록을 다루는 객체를 지정할 때,
  // 특정클래스( ex> AbstractList, LinkedList, ArrayList) 대신
  // 사용규칙 ( ex> List)을 지정함으로써 다 다양한 타입의 객체로 교체할 수 있다.
  List<Board> boardList;

  public BoardHandler(Prompt prompt, List<Board> list) {
    // List 파라미터는 List 인터페이스를 구현한 객체를 받는다.
    this.prompt = prompt;
    this.boardList = list;
  }

  public void addBoard() {
    Board board = new Board();

    board.setNo(prompt.inputInt("번호? "));
    board.setTitle(prompt.inputString("내용? "));
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);
    System.out.println("저장하였습니다.");
  }

  public void listBoard() {
    Board[] arr = new Board[this.boardList.size()];
    arr = this.boardList.toArray(arr);

    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }

  public void detailBoard() {
    int index = indexOfBoard(prompt.inputInt("게시물 번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조화수: %d\n", board.getViewCount());
  }

  public void updateBoard() {
    int index = indexOfBoard(prompt.inputInt("게시물 번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Board oldBoard = this.boardList.get(index);

    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setTitle(prompt.inputString(String.format("내용(%s)? ", oldBoard.getTitle()),
        oldBoard.getTitle()));
    newBoard.setDate(oldBoard.getDate());
    newBoard.setViewCount(oldBoard.getViewCount());

    if (!newBoard.equals(oldBoard)) {
      this.boardList.set(index, newBoard);
      System.out.println("게시글을 변경했습니다."); 
    } else {
      System.out.println("게시글 변경을 취소했습니다.");
    }
  }

  public void deleteBoard() {
    int index = indexOfBoard(prompt.inputInt("게시물 번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다.");
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
