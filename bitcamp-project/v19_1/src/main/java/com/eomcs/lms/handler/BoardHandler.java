package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.util.ArrayList;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  Scanner input;
  ArrayList<Board> boardList;

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>();
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new ArrayList<>(capacity);
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine();
    System.out.print("내용? ");
    board.setTitle(input.nextLine());
    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);
    System.out.println("저장하였습니다.");
  }

  public void listBoard() {
    // boardList에 보관된 값을 받을 배열을 준비한다.
    Board[] arr = new Board[this.boardList.size()];

    // toArray에게 빈 배열을 넘겨서 복사받는다.
    this.boardList.toArray(arr);

    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }

  public void detailBoard() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine();

    Board board = this.boardList.get(index);

    if (board == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조화수: %d\n", board.getViewCount());
  }

  public void updateBoard() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine();

    Board oldBoard = this.boardList.get(index);

    if (oldBoard == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("내용(%s)? ", oldBoard.getTitle());
    String title = input.nextLine();

    if (title.length() == 0) {
      System.out.println("게시물 변경을 취소했습니다");
      return;
    }

    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setTitle(title);
    newBoard.setDate(new Date(System.currentTimeMillis()));
    newBoard.setViewCount(oldBoard.getViewCount());

    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다.");
  }

  public void deleteBoard() {
    System.out.print("게시글 인덱스? ");
    int index = input.nextInt();
    input.nextLine();
    Board board = this.boardList.get(index);

    if (board == null) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    boardList.remove(index);
    System.out.println("게시글을 삭제했습니다.");
  }
}
