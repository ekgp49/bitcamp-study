package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  // 인스턴스 필드 => new 명령을 실행해야만 생성되는 변수
  // => 개별적으로 관리되어야 하는 값일 경우 인스턴스 필드로 선언한다.
  Board[] boards;
  int boardCount = 0;

  // 사용자로부터 게시물 데이터를 입력받을 때 키보드로부터 입력받았지만 향후 네트워크나
  // 파일에서도 입력받을 수 있다.
  // 이런 경우를 대비하여 입력 데이터를 읽는 것을 keyboard로 한정하지 말자
  // 게시판마다 입력받는 방식을 다르게 할 수 있도록 인스턴스 변수로 선언하자.
  Scanner input;
  
  // 클래스 필드 => method area에 클래스 코드가 로딩될 때 자동생성된다.
  // => 공통으로 사용할 값일 경우 클래스 필드로 선언한다.
  static final int BOARD_SIZE = 400;
  
  // 생성자(Constructor)
  // => 인스턴스를 생성할 때 반드시 호출되는 메서드
  // => new 명령을 실행할 때 호출할 생성자를 지정할 수 있다
  // => 주로 의존 객체를 초기화시키는 코드를 넣는다.
  // => 생성자는 리턴값이 없고 클래스 이름과 같은 이름으로 메서드를 정의한다.
  // => 생성자를 실행할 때 사용할 값은 파라미터로 받는다.
  public BoardHandler(Scanner input) {
    // BoardHandler를 실행하려면 데이터를 입력받는 도구가 반드시 있어야 한다.
    // 이런 도구를 의존객체(dependency object)라 부른다.
    // 보통 dependency라 줄여서 부른다
    // 생성자를 해야 할 일은 인스턴스를 생성할 때 이런 의존 객체를 반드시 초기화시키도록 하는 것이다.
    this.input = input;
    this.boards = new Board[BOARD_SIZE];
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    if (capacity < BOARD_SIZE || capacity > 10000)
      this.boards = new Board[BOARD_SIZE];
    else
      this.boards = new Board[capacity];
  }
  
  public void addBoard() {
    Board board = new Board(); 

    System.out.print("번호? ");
    board.no = input.nextInt();
    input.nextLine();
    System.out.print("내용? ");
    board.title = input.nextLine();
    board.date = new Date(System.currentTimeMillis());
    board.viewCount = 0;

    this.boards[this.boardCount++] = board;
    System.out.println("저장하였습니다.");
  }

  public void listBoard() {
    for (int i = 0; i < this.boardCount; i++) {
      Board b = this.boards[i];
      System.out.printf("%d, %s, %s, %d\n", b.no, b.title, b.date, b.viewCount);
    }
  }
  
  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int no = input.nextInt();
    input.nextLine();
    
    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == no) {
        board = this.boards[i];
        break;
      } 
    }
    
    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }
    
    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조화수: %d\n", board.viewCount);
  }
}
