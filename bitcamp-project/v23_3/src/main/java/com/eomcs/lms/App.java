package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.ArrayList;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;
public class App {
  // 서브 클래스에 공통 분모(멤버)를 물려주는 용도의 클래스는 직접 인스턴스를 생성하지 못하도록
  // 추상 클래스로 선언한다.
  // 개발자가 추상 클래스 여부를 즉각적으로 확인할 수 있도록 
  // 보통 클래스 이름은 Abstarctxxxx형식으로 짓는다.
  static Scanner keyboard = new Scanner(System.in); 
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {
    Prompt prompt = new Prompt(keyboard);

    LessonHandler lessonHandler = new LessonHandler(prompt, new LinkedList<>());
    MemberHandler memberHandler = new MemberHandler(prompt, new ArrayList<>());

    // 단지 유지보수만을 위해 공통분모를 뽑아서 만든게 List이다.
    // 즉 List클래스는 실제 작업을 하는 클래스가 아니다.
    // 그럼에도 불구하고 개발자가 다음과 같이 List 객체를 사용하려 한다면 막을 수가 없다.
    // => 실행시 아무런 작업을 수행하지 않을 것이다.
    // => List 클래스에 정의된 메서드는 아무것도 하지 않는다.
    // => 이렇게 Generalization으로 만든 클래스의 경우 서브클래스에게 공통 분모를 물려주기
    //    위한 용도로 사용되므로 이런 류의 클래스는 직접 인스턴스를 생성하지 못하도록 막아야한다.
    // => 이런 용도로 사용하는 문법이 추상 클래스(Abstract class)이다.
    // 
    // 다음과 같이 List 클래스를 추상 클래스로 만들면 다음과 같이 인스턴스를 생성할 수 없다.
    // 아예 인스턴스 생성을 원천적으로 차단하는 효과가 있다.
//    BoardHandler boardHandler = new BoardHandler(prompt, new AbstractList<>()); // 컴파일 오류!
    BoardHandler boardHandler = new BoardHandler(prompt, new LinkedList<>());
    // 반드시 List 클래스의 일반 하위 객체를 정의해야 한다.
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
          printCommandHistory();
          break;
        case "history2" :
          printCommandHistory2();
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


  private static void printCommandHistory() {
    Stack<String> historyStack = commandStack.clone(); 
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;

      if ((count % 5) == 0 && !historyStack.empty()) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    System.out.println("명령 목록 출력!");
    int count = 0;
    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());
      if ((++count % 5) == 0 && historyQueue.size() > 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}
