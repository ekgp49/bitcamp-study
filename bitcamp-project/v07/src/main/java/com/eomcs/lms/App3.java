package com.eomcs.lms;


import java.util.Scanner;
import java.sql.Date;

// 반복문 사용
public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    // 게시글 데이터를 저장할 메모리를 설계한다.
    class Board {
      int no;
      String title;
      Date date;
      int viewCount;
    }
   
    final int SIZE = 100;

    Board[] boards =  new Board[SIZE]; 

    String response = "";
    int count = 0;
    for (int i = 0; i < SIZE; i++) {

      Board board = new Board(); //유지 보수를 위해 주소를 가리키는 주소를 하나 더 만들면 좋음. 코드 간결해보이고 좋다

      System.out.print("번호? ");
      board.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("내용? ");
      board.title = keyboard.nextLine();

      board.date = new Date(System.currentTimeMillis());
      board.viewCount = 0;

      boards[i] = board;
      
      count++;

      System.out.println("계속 입력하시겠습니까?(Y / N)");
      response = keyboard.nextLine();

      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    //
    // Date today = new Date(System.currentTimeMillis());
    //// java.util.Date today = new java.util.Date(); java.util 안하면 java.sql로 간주
    //

    // int viewCount = 0;

    System.out.println();

    for (int i = 0; i < count; i++) {
      Board board = boards[i];

      System.out.printf("%d, %s, %s, %d\n", board.no, board.title, board.date, board.viewCount);
    }

    // System.out.printf("번호: %d\n", no);
    // System.out.printf("내용: %s\n", content);
    // System.out.printf("작성일: %s\n", today);
    // System.out.printf("조회수: %d\n", viewCount);

    keyboard.close();
  }
}
