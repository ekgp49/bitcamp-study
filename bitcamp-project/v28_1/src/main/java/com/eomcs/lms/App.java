package com.eomcs.lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
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

      // .csv 파일에서 한줄 단위로 문자열을 읽는 기능이 필요하다.
      // FileReader에게는 그런 기능이 없다.
      // 그래서 FileReader를 그대로 사용할 수 없고
      // 이 객체에 다른 도구를 연결하여 사용할 것이다.
      dataScan = new Scanner(in);
      int count = 0;

      while (true) {
        try {
          // 파일에서 한 줄을 읽는다.
          String line = dataScan.nextLine();

          System.out.println("asd");
          // 한 줄을 ,로 나눈다.
          String[] data = line.split(",");

          // 한 줄에 들어있던 데이터를 추출하여 Lesson 객체에 담는다.
          // 데이터 순서는 다음과 같다 =>
          // 번호, 강의명, 설명, 시작일, 종료일, 총강의시간, 일강의시간
          Lesson lesson = new Lesson();
          lesson.setNo(Integer.parseInt(data[0]));
          lesson.setTitle(data[1]);
          lesson.setDescription(data[2]);
          lesson.setStartDate(Date.valueOf(data[3]));
          lesson.setEndDate(Date.valueOf(data[4]));
          lesson.setTotalHours(Integer.parseInt(data[5]));
          lesson.setDayHours(Integer.parseInt(data[6]));

          lessonList.add(lesson);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 수업데이터를 로딩했습니다.\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생 - " + e.getMessage());
      // 파일에서 데이터를 읽다가 오류가 발생하더라도 시스템을 멈추지 않고 계속 실행하게 한다.
      // 이것이 예외처리를 하는 이유이다!
    } finally {
      // 자원이 연결된 경우에는 다른 자원을 이용하는 객체부터 닫는다.
      try {
        dataScan.close();
      } catch (Exception e) {

      }

      try {
        in.close();
      } catch (Exception e) {
        // close() 실행하다가 오류가 발생한 경우는 무시한다
        // 왜? 닫다가 발생한 오류는 특별히 처리할 게 없다.
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
          String line = dataScan.nextLine();

          String[] data = line.split(",");

          Member member = new Member();
          member.setNo(Integer.parseInt(data[0]));
          member.setName(data[1]);
          member.setEmail(data[2]);
          member.setPassword(data[3]);
          member.setPhoto(data[4]);
          member.setTel(data[5]);
          member.setRegisteredDate(Date.valueOf(data[6]));

          memberList.add(member);
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
        String line = String.format("%d,%s,%s,%s,%s,%d,%d\n", lesson.getNo(), lesson.getTitle(),
            lesson.getDescription(), lesson.getStartDate(), lesson.getEndDate(),
            lesson.getTotalHours(), lesson.getDayHours());

        out.write(line);
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
        // 수업 목록에서 수업 데이터를 꺼내 CSV 형식의 문자열로 만든다.
        String line = String.format("%d,%s,%s,%s,%s,%s,%s\n", member.getNo(), member.getName(),
            member.getEmail(), member.getPassword(), member.getPhoto(), member.getTel(),
            member.getRegisteredDate());

        out.write(line);
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
