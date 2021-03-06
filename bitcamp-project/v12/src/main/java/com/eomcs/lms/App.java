package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardHandler2;
import com.eomcs.lms.handler.BoardHandler3;
import com.eomcs.lms.handler.BoardHandler4;
import com.eomcs.lms.handler.BoardHandler5;
import com.eomcs.lms.handler.BoardHandler6;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
public class App {

  static Scanner keyboard = new Scanner(System.in); 
 
  public static void main(String[] args) {
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해 줘야 한다.
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    BoardHandler2.keyboard = keyboard;
    BoardHandler3.keyboard = keyboard;
    BoardHandler4.keyboard = keyboard;
    BoardHandler5.keyboard = keyboard;
    BoardHandler6.keyboard = keyboard;
    
    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        // 분리된 코드(메서드)를 실행(호출)시킨다.
        case "/lesson/add" :
          LessonHandler.addLesson();
          break;
        case "/lesson/list" :
          LessonHandler.listLesson();
          break;
        case "/member/add" :
          MemberHandler.addMember();
          break;
        case "/member/list" :
          MemberHandler.listMember();
          break;
        case "/board/add" :
          BoardHandler.addBoard();
          break;
        case "/board/list" :
          BoardHandler.listBoard();
          break;
        case "/board/detail" :
          BoardHandler.detailBoard();
          break;
        case "/board2/add" :
          BoardHandler2.addBoard();
          break;
        case "/board2/list" :
          BoardHandler2.listBoard();
          break;
        case "/board2/detail" :
          BoardHandler2.detailBoard();
          break;
        case "/board3/add" :
          BoardHandler3.addBoard();
          break;
        case "/board3/list" :
          BoardHandler3.listBoard();
          break;
        case "/board3/detail" :
          BoardHandler3.detailBoard();
          break;
        case "/board4/list" :
          BoardHandler4.listBoard();
          break;
        case "/board4/detail" :
          BoardHandler4.detailBoard();
          break;
        case "/board5/list" :
          BoardHandler5.listBoard();
          break;
        case "/board5/detail" :
          BoardHandler5.detailBoard();
          break;
        case "/board6/list" :
          BoardHandler6.listBoard();
          break;
        case "/board6/detail" :
          BoardHandler6.detailBoard();
          break;
        
        default :
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 입력입니다.");
          }
      }
    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕~~");

    keyboard.close();
  }

}
