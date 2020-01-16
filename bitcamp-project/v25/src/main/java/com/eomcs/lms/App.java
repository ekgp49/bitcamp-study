package com.eomcs.lms;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;
public class App {
  static Scanner keyboard = new Scanner(System.in); 
  
  // java.util.Stack에서 제공하는 Iterator 객체는 FIFO 방식으로 값을 꺼내준다.
  // LIFO 방식으로 꺼내는 iterator가 필요하다면
  // java.util.deque 구현체를 사용하라
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {
    Prompt prompt = new Prompt(keyboard);

    LessonHandler lessonHandler = new LessonHandler(prompt, new LinkedList<>());
    MemberHandler memberHandler = new MemberHandler(prompt, new ArrayList<>());
    BoardHandler boardHandler = new BoardHandler(prompt, new LinkedList<>());
    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      if (!command.equals("")) {
        commandStack.push(command);
        commandQueue.offer(command);
      }

      switch (command) {
        case "/lesson/add" :
          lessonHandler.addLesson();
          break;
        case "/lesson/list" :
          lessonHandler.listLesson();
          break;
        case "/lesson/detail" :
          lessonHandler.detailLesson();
          break;
        case "/lesson/update" :
          lessonHandler.updateLesson();
          break;
        case "/lesson/delete" :
          lessonHandler.deleteLesson();
          break;
        case "/member/add" :
          memberHandler.addMember();
          break;
        case "/member/list" :
          memberHandler.listMember();
          break;
        case "/member/detail" :
          memberHandler.detailMember();
          break;
        case "/member/update" :
          memberHandler.updateMember();
          break;
        case "/member/delete" :
          memberHandler.deleteMember();
          break;
        case "/board/add" :
          boardHandler.addBoard();
          break;
        case "/board/list" :
          boardHandler.listBoard();
          break;
        case "/board/detail" :
          boardHandler.detailBoard();
          break;
        case "/board/update" :
          boardHandler.updateBoard();
          break;
        case "/board/delete" :
          boardHandler.deleteBoard();
          break;
        case "history" :
          printCommandHistory(commandStack.iterator());
          break;
        case "history2" :
          printCommandHistory(commandQueue.iterator());
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


  private static void printCommandHistory(Iterator<String> command) {
    int count = 0;
    while (command.hasNext()) {
      System.out.println(command.next());
      if ((++count % 5) == 0 && command.hasNext()) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}
