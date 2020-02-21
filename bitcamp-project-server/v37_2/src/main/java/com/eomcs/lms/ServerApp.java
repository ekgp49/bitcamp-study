package com.eomcs.lms;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.servlet.BoardListServlet;
import com.eomcs.lms.servlet.LessonListServlet;
import com.eomcs.lms.servlet.MemberListServlet;
import com.eomcs.lms.servlet.Servlet;

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  Map<String, Servlet> servletMap = new HashMap<>();

  ExecutorService executorService = Executors.newCachedThreadPool();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitailized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  public void service() {

    notifyApplicationInitailized();

    BoardDao boardDao = (BoardDao) context.get("boardDao");
    LessonDao lessonDao = (LessonDao) context.get("lessonDao");
    MemberDao memberDao = (MemberDao) context.get("memberDao");

    servletMap.put("/board/list", new BoardListServlet(boardDao));
    // servletMap.put("/board/add", new BoardAddServlet(boardDao));
    // servletMap.put("/board/detail", new BoardDetailServlet(boardDao));
    // servletMap.put("/board/update", new BoardUpdateServlet(boardDao));
    // servletMap.put("/board/delete", new BoardDeleteServlet(boardDao));
    //
    servletMap.put("/lesson/list", new LessonListServlet(lessonDao));
    // servletMap.put("/lesson/add", new LessonAddServlet(lessonDao));
    // servletMap.put("/lesson/detail", new LessonDetailServlet(lessonDao));
    // servletMap.put("/lesson/update", new LessonUpdateServlet(lessonDao));
    // servletMap.put("/lesson/delete", new LessonDeleteServlet(lessonDao));
    //
    servletMap.put("/member/list", new MemberListServlet(memberDao));
    // servletMap.put("/member/add", new MemberAddServlet(memberDao));
    // servletMap.put("/member/detail", new MemberDetailServlet(memberDao));
    // servletMap.put("/member/update", new MemberUpdateServlet(memberDao));
    // servletMap.put("/member/delete", new MemberDeleteServlet(memberDao));

    try (ServerSocket serverSocket = new ServerSocket(9999)) {
      System.out.println("클라이언트 연결 대기중...");
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었음");

        // 스레드 풀을 사용할 때는 직접 스레드를 만들지 않는다.
        // 단지 스레드풀에 스레드가 실행할 코드(Runnable 구현체)를 제출한다.
        // 스레드풀에 스레드가 없으면 새로 만들어 Runnable 구현체를 실행한다
        // 스레드풀에 스레드가 있으면 그 스레드를 이용하여 Runnable 구현체를 실행한다.
        executorService.submit(() -> {
          processRequest(socket);
          System.out.println("------------------------------------------------");
        });
      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생");
    }
    notifyApplicationDestroyed();
    // 스레드풀을 다 사용했으면 종료하라고 해야한다
    // => 스레드풀을 당장 종료시키는 것이 아니다.
    // => 스레드풀에 소속된 스레드들의 작업이 모두 끝나면 종료하라는 뜻
    executorService.shutdown();
  }

  int processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      String request = in.nextLine();
      System.out.println("클라이언트가 보낸 메시지를 수신하였음!");
      System.out.printf("=> %s\n", request);

      if (request.equalsIgnoreCase("/server/stop")) {
        return 9;
      }

      Servlet servlet = servletMap.get(request);
      if (servlet != null) {
        try {
          servlet.service(in, out);
        } catch (Exception e) {
          out.println("요청 처리 중 오류 발생");
          out.println(e.getMessage());
          System.out.println("클라이언트 요청 처리 중 오류발생");
          e.printStackTrace();
        }
      } else {
        notFount(out);
      }

      out.println("!end!");
      out.flush();
      System.out.println("클라이언트에게 응답하였음");
    } catch (Exception e) {
      System.out.println("예외발생: ");
      e.printStackTrace();
      return -1;
    }
    return 0;
  }

  private void notFount(PrintStream out) throws IOException {
    out.println("요청한 명령을 처리할 수 없습니다");
  }

  private void quit(PrintStream out) throws IOException {
    out.println("OK");
    out.flush();
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템 입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
