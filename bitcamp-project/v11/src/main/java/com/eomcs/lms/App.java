package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
public class App {

  static Scanner keyboard = new Scanner(System.in); 
 
  public static void main(String[] args) {
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해 줘야 한다.
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    
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
