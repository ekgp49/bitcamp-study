package com.eomcs.lms;

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

public class ServerApp {

  // 옵저버 관련 코드
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

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

  @SuppressWarnings("unchecked")
  int processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      List<Board> boardList = (List<Board>) context.get("boardList");
      List<Lesson> lessonList = (List<Lesson>) context.get("lessonList");
      List<Member> memberList = (List<Member>) context.get("memberList");

      while (true) {
        String request = in.readUTF();
        if (request.equals("quit")) {
          out.writeUTF("OK");
          out.flush();
          break;
        }
        if (request.equals("/server/stop")) {
          out.writeUTF("OK");
          out.flush();
          return 9;
        }
        if (request.equals("/board/list")) {
          out.writeUTF("OK");
          out.reset();
          out.writeObject(boardList);
        } else if (request.equals("/board/add")) {
          try {
            Board board = (Board) in.readObject();
            boardList.add(board);
            System.out.println("게시물을 저장했습니다.");
            out.writeUTF("OK");
          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());
          }
        } else if (request.equals("/board/detail")) {
          int no = in.readInt();
          Board board = null;
          for (Board b : boardList) {
            if (b.getNo() == no) {
              board = b;
            }
          }
          if (board == null) {
            out.writeUTF("FAIL");
            out.writeUTF("해당번호의 게시물이 없습니다.");
          } else {
            out.writeUTF("OK");
            out.writeObject(board);
          }
        } else if (request.equals("/board/update")) {
          int no = in.readInt();
          Board board = (Board) in.readObject();
          int index = -1;
          for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getNo() == no) {
              index = i;
              break;
            }
          }
          boardList.set(index, board);
          out.writeUTF("OK");
        } else if (request.equals("/board/delete")) {
          int no = in.readInt();
          int index = -1;
          for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getNo() == no) {
              index = i;
              break;
            }
          }
          if (index == -1) {
            out.writeUTF("FAIL");
            out.writeUTF("해당번호의 게시물이 없습니다.");
          } else {
            out.writeUTF("OK");
            boardList.remove(index);
            out.writeUTF("게시글을 삭제했습니다.");
          }
        } else if (request.equals("/lesson/list")) {
          out.writeUTF("OK");
          out.reset();
          out.writeObject(lessonList);
        } else if (request.equals("/lesson/add")) {
          try {
            Lesson lesson = (Lesson) in.readObject();
            lessonList.add(lesson);
            System.out.println("수업정보를 저장했습니다.");
            out.writeUTF("OK");
          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());
          }
        } else if (request.equals("/lesson/detail")) {
          int no = in.readInt();
          Lesson lesson = null;
          for (Lesson b : lessonList) {
            if (b.getNo() == no) {
              lesson = b;
            }
          }
          if (lesson == null) {
            out.writeUTF("FAIL");
            out.writeUTF("해당번호의 수업정보가 없습니다.");
          } else {
            out.writeUTF("OK");
            out.writeObject(lesson);
          }
        } else if (request.equals("/lesson/update")) {
          int no = in.readInt();
          Lesson lesson = (Lesson) in.readObject();
          int index = -1;
          for (int i = 0; i < lessonList.size(); i++) {
            if (lessonList.get(i).getNo() == no) {
              index = i;
              break;
            }
          }
          lessonList.set(index, lesson);
          out.writeUTF("OK");
        } else if (request.equals("/lesson/delete")) {
          int no = in.readInt();
          int index = -1;
          for (int i = 0; i < lessonList.size(); i++) {
            if (lessonList.get(i).getNo() == no) {
              index = i;
              break;
            }
          }
          if (index == -1) {
            out.writeUTF("FAIL");
            out.writeUTF("해당번호의 수업정보가 없습니다.");
          } else {
            out.writeUTF("OK");
            lessonList.remove(index);
            out.writeUTF("수업정보를 삭제했습니다.");
          }
        } else if (request.equals("/member/list")) {
          out.writeUTF("OK");
          out.reset();
          out.writeObject(memberList);
        } else if (request.equals("/member/add")) {
          try {
            Member member = (Member) in.readObject();
            memberList.add(member);
            System.out.println("회원정보를 저장했습니다.");
            out.writeUTF("OK");
          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());
          }
        } else if (request.equals("/member/detail")) {
          int no = in.readInt();
          Member member = null;
          for (Member b : memberList) {
            if (b.getNo() == no) {
              member = b;
            }
          }
          if (member == null) {
            out.writeUTF("FAIL");
            out.writeUTF("해당번호의 회원정보이 없습니다.");
          } else {
            out.writeUTF("OK");
            out.writeObject(member);
          }
        } else if (request.equals("/member/update")) {
          int no = in.readInt();
          Member member = (Member) in.readObject();
          int index = -1;
          for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getNo() == no) {
              index = i;
              break;
            }
          }
          memberList.set(index, member);
          out.writeUTF("OK");
        } else if (request.equals("/member/delete")) {
          int no = in.readInt();
          int index = -1;
          for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getNo() == no) {
              index = i;
              break;
            }
          }
          if (index == -1) {
            out.writeUTF("FAIL");
            out.writeUTF("해당번호의 회원정보이 없습니다.");
          } else {
            out.writeUTF("OK");
            memberList.remove(index);
            out.writeUTF("회원정보를 삭제했습니다.");
          }
        } else {
          out.writeUTF("FAIL");
          out.writeUTF("요청한 명령을 처리할 수 없습니다");
        }
        out.flush();
      }
      System.out.println("클라이언트에 메시지를 전송하였음!");
      return 0;
    } catch (Exception e) {
      System.out.println("예외발생: ");
      e.printStackTrace();
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템 입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
