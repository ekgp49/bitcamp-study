// LMS 클라이언트
package com.eomcs.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  Deque<String> commandStack;
  Queue<String> commandQueue;

  public ClientApp() throws Exception {
    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>();
  }

  public void service() {

    while (true) {
      String command;
      command = prompt.inputString("\n명령> ");
      if (command.length() == 0) {
        continue;
      }

      if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      } else if (command.equalsIgnoreCase("quit")) {
        break;
      }

      commandStack.push(command);
      commandQueue.offer(command);

      processCommand(command);

      if (command.endsWith("/server/stop")) {
        // 임의요청 또보내기
        processCommand(command);
      }
    }
    keyboard.close();
  }

  private void processCommand(String command) {
    // 명령어 형식을 변경한다.
    // 기존 방식 :
    // 예) /board/list
    // 새 방식
    // 예) bitcamp://localhost/board/list
    String host = null;
    int port = 9999;
    String servletPath = null;
    // 명령어를 분석하여 서버주소, 포트번호, 실행시킬 작업명을 분리한다.
    try {
      if (!command.startsWith("bitcamp://")) {
        throw new Exception("명령어 형식이 옳지 않습니다.");
      }
      String url = command.substring(10);
      int index = url.indexOf("/");
      String[] str = url.substring(0, index).split(":");
      host = str[0];
      if (str.length == 2) {
        port = Integer.parseInt(str[1]);
      }

      servletPath = url.substring(index);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try (Socket socket = new Socket(host, port);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
      // 서버에 명령을 보낸다.
      out.println(servletPath);
      out.flush();
      while (true) {
        String response = in.nextLine();
        if (response.equals("!end!")) {
          break;
        } else if (response.equals("!{}!")) {
          String input = prompt.inputString("");
          out.println(input);
          out.flush();
        } else {
          System.out.println(response);
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  private void printCommandHistory(Iterator<String> command) {
    int count = 0;
    while (command.hasNext()) {
      System.out.println(command.next());
      if (++count % 5 == 0 && command.hasNext()) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 수업 관리 시스템 입니다.");

    ClientApp app = new ClientApp();
    app.service();
  }
}
