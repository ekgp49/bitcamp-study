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

public class ServerApp {

  // 옵저버 관련 코드
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

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


      while (true) {
        String request = in.readUTF();
        switch (request) {
          case "quit":
            quit(out);
            return 0;
          case "/server/stop":
            quit(out);
            return 9;
          case "/board/list":
            listBoard(out);
            break;
          case "/board/add":
            addBoard(in, out);
            break;
          case "/board/detail":
            detailBoard(in, out);
            break;
          case "/board/update":
            updateBoard(in, out);
            break;
          case "/board/delete":
            deleteBoard(in, out);
            break;
          case "/lesson/list":
            listLesson(out);
            break;
          case "/lesson/add":
            addLesson(in, out);
            break;
          case "/lesson/detail":
            detailLesson(in, out);
            break;
          case "/lesson/update":
            updateLesson(in, out);
            break;
          case "/lesson/delete":
            deleteLesson(in, out);
            break;
          case "/member/list":
            listMember(out);
            break;
          case "/member/add":
            addMember(in, out);
            break;
          case "/member/detail":
            detailMember(in, out);
            break;
          case "/member/update":
            updateMember(in, out);
            break;
          case "/member/delete":
            deleteMember(in, out);
            break;
          default:
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

  private void deleteMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
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
  }

  private void updateMember(ObjectInputStream in, ObjectOutputStream out)
      throws IOException, ClassNotFoundException {
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
  }

  private void detailMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
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
  }

  private void addMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Member member = (Member) in.readObject();
      memberList.add(member);
      System.out.println("회원정보를 저장했습니다.");
      out.writeUTF("OK");
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void listMember(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(memberList);
  }

  private void deleteLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
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
  }

  private void updateLesson(ObjectInputStream in, ObjectOutputStream out)
      throws IOException, ClassNotFoundException {
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
  }

  private void detailLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
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
  }

  private void addLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Lesson lesson = (Lesson) in.readObject();
      lessonList.add(lesson);
      System.out.println("수업정보를 저장했습니다.");
      out.writeUTF("OK");
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void listLesson(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(lessonList);
  }

  private void deleteBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
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
  }

  private void updateBoard(ObjectInputStream in, ObjectOutputStream out)
      throws IOException, ClassNotFoundException {
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
  }

  private void detailBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
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
  }

  private void addBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Board board = (Board) in.readObject();
      boardList.add(board);
      System.out.println("게시물을 저장했습니다.");
      out.writeUTF("OK");
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void listBoard(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(boardList);
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템 입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
