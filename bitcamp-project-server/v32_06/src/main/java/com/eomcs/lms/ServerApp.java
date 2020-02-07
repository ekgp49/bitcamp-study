package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.servlet.BoardAddServlet;
import com.eomcs.lms.servlet.BoardDeleteServlet;
import com.eomcs.lms.servlet.BoardDetailServlet;
import com.eomcs.lms.servlet.BoardListServlet;
import com.eomcs.lms.servlet.BoardUpdateServlet;
import com.eomcs.lms.servlet.LessonAddServlet;
import com.eomcs.lms.servlet.LessonDeleteServlet;
import com.eomcs.lms.servlet.LessonDetailServlet;
import com.eomcs.lms.servlet.LessonListServlet;
import com.eomcs.lms.servlet.LessonUpdateServlet;
import com.eomcs.lms.servlet.MemberAddServlet;
import com.eomcs.lms.servlet.MemberDeleteServlet;
import com.eomcs.lms.servlet.MemberDetailServlet;
import com.eomcs.lms.servlet.MemberListServlet;
import com.eomcs.lms.servlet.MemberUpdateServlet;
import com.eomcs.lms.servlet.Servlet;

public class ServerApp {

  // 옵저버 관련 코드
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  // 커맨드 디자인 패턴 관련 코드
  Map<String, Servlet> servletMap = new HashMap();

  List<Board> boardList;
  List<Lesson> lessonList;
  List<Member> memberList;


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

  @SuppressWarnings("unchecked")
  public void service() {
    notifyApplicationInitailized();

    boardList = (List<Board>) context.get("boardList");
    lessonList = (List<Lesson>) context.get("lessonList");
    memberList = (List<Member>) context.get("memberList");

    servletMap.put("/board/list", new BoardListServlet(boardList));
    servletMap.put("/board/add", new BoardAddServlet(boardList));
    servletMap.put("/board/detail", new BoardDetailServlet(boardList));
    servletMap.put("/board/update", new BoardUpdateServlet(boardList));
    servletMap.put("/board/delete", new BoardDeleteServlet(boardList));

    servletMap.put("/lesson/list", new LessonListServlet(lessonList));
    servletMap.put("/lesson/add", new LessonAddServlet(lessonList));
    servletMap.put("/lesson/detail", new LessonDetailServlet(lessonList));
    servletMap.put("/lesson/update", new LessonUpdateServlet(lessonList));
    servletMap.put("/lesson/delete", new LessonDeleteServlet(lessonList));

    servletMap.put("/member/list", new MemberListServlet(memberList));
    servletMap.put("/member/add", new MemberAddServlet(memberList));
    servletMap.put("/member/detail", new MemberDetailServlet(memberList));
    servletMap.put("/member/update", new MemberUpdateServlet(memberList));
    servletMap.put("/member/delete", new MemberDeleteServlet(memberList));

    try (ServerSocket serverSocket = new ServerSocket(9999)) {
      System.out.println("클라이언트 연결 대기중...");
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었음");
        if (processRequest(socket) == 9) {
          break;
        }

        System.out.println("------------------------------------------------");
      }
    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생");
      return;
    }
    notifyApplicationDestroyed();
  }

  int processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      while (true) {
        String request = in.readUTF();
        System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

        switch (request) {
          case "quit":
            quit(out);
            return 0;
          case "/server/stop":
            quit(out);
            return 9;
        }

        Servlet servlet = servletMap.get(request);
        if (servlet != null) {
          try {
            out.writeUTF("OK");
            servlet.service(in, out);
          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());
            System.out.println("클라이언트 요청 처리 중 오류발생");
            e.printStackTrace();
          }
        } else {
          notFount(out);
        }
        out.flush();
        System.out.println("클라이언트에게 응답하였음");
      }
    } catch (Exception e) {
      System.out.println("예외발생: ");
      e.printStackTrace();
      return -1;
    }
  }

  private void notFount(ObjectOutputStream out) throws IOException {
    out.writeUTF("FAIL");
    out.writeUTF("요청한 명령을 처리할 수 없습니다");
  }

  private void quit(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.flush();
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템 입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
