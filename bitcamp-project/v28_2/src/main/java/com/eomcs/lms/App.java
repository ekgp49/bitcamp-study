package com.eomcs.lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.ComputePlusCommand;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Prompt;

public class App {
  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();
  static List<Lesson> lessonList = new LinkedList<>();
  static List<Board> boardList = new LinkedList<>();
  static List<Member> memberList = new LinkedList<>();

  public static void main(String[] args) {

    // 파일에서 데이터 로딩하기
    loadLessonData();
    loadMemberData();
    loadBoardData();

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();


    commandMap.put("/board/add", new BoardAddCommand(prompt, boardList));
    commandMap.put("/board/list", new BoardListCommand(boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, boardList));
    commandMap.put("/lesson/add", new LessonAddCommand(prompt, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(prompt, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(prompt, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(prompt, lessonList));
    commandMap.put("/member/add", new MemberAddCommand(prompt, memberList));
    commandMap.put("/member/list", new MemberListCommand(memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(prompt, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(prompt, memberList));
    commandMap.put("/member/command", new MemberDeleteCommand(prompt, memberList));
    commandMap.put("/hello", new HelloCommand(prompt));
    commandMap.put("/compute/plus", new ComputePlusCommand(prompt));

    String command;

    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      if (command.length() == 0) {
        continue;
      }

      if (command.equalsIgnoreCase("quit")) {
        System.out.println("안녕~~");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      commandStack.push(command);

      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);
      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
        }
      } else {
        System.out.println("실행할 수 없는 입력입니다.");
      }
    }
    keyboard.close();

    saveLessonData();
    saveMemberData();
    saveBoardData();
    // 데이터를 파일에 저장
  }

  private static void printCommandHistory(Iterator<String> command) {
    int count = 0;
    while (command.hasNext()) {
      System.out.println(command.next());
      if (++count % 5 == 0 && command.hasNext()) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  private static void loadLessonData() {
    // 데이터가 보관된 파일의 정보를 준비한다.
    File file = new File("./lesson.csv");
    // 파일을 읽을 때 사용할 도구를 준비한다.
    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          String line = dataScan.nextLine();
          lessonList.add(Lesson.valueOf(line));
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 수업데이터를 로딩했습니다.\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생 - " + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {

      }

      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void loadMemberData() {
    File file = new File("./member.csv");

    FileReader in = null;
    Scanner dataScan = null;
    try {
      in = new FileReader(file);

      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          memberList.add(Member.valueOf(dataScan.nextLine()));
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 회원데이터를 로딩했습니다.\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생 - " + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {

      }

      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.csv");
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      dataScan = new Scanner(in);
      int count = 0;
      while (true) {
        try {
          boardList.add(Board.valueOf(dataScan.nextLine()));
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 게시글 데이터를 로딩했습니다.\n", count);

    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생 - " + e.getMessage());
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
      }
      try {
        in.close();
      } catch (Exception e) {
      }
    }

  }

  private static void saveLessonData() {
    // 데이터가 보관된 파일을 정보를 준비한다.
    File file = new File("./lesson.csv");

    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;

      for (Lesson lesson : lessonList) {
        out.write(lesson.toCsvString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시한다.
      }
    }
  }

  private static void saveMemberData() {
    File file = new File("./member.csv");

    FileWriter out = null;

    try {
      // 파일에 데이터를 저장할 때 사용할 도구를 준비한다.
      out = new FileWriter(file);
      int count = 0;

      for (Member member : memberList) {
        out.write(member.toCsvString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시한다.
      }
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.csv");

    FileWriter out = null;

    try {
      out = new FileWriter(file);
      int count = 0;

      for (Board board : boardList) {
        out.write(board.toCsvString() + "\n");
        count++;
      }
      System.out.printf("총 %d 개의 게시글 데이터를 저장했습니다.\n", count);

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // FileWriter를 닫을 때 발생하는 예외는 무시한다.
      }
    }
  }

}
