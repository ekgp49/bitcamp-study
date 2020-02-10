// 통신방식 - stateful
package com.eomcs.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// stateful 방식
// 서버와 연결한 후 클라이언트에서 연결을 끊을 때 까지 계속해서 연결을 유지하며
// 클라이언트 요청을 처리한다.
// => 단점:
// 한 번 연결하면 클라이언트가 연결을 끊을 때까지 계속 유지한다.
// 클라이언트가 작업을 요청하지 않더라도
// 서버에 계속 연결정보를 유지해야 하기 때문에
// 서버 메모리를 많이 차지하고
// 동시에 많은 클라이언트의 요청을 처리하기 힘들다.


// => 장점:
// 한 번 서버에 연결되면 클라이언트가 연결을 끊을 때까지 유지되기 때문에
// 요청할 때마다 매번 연결 작업을 처리할 필요가 없다.
// 따라서 요청에 대한 응답이 빠르다.
// 또한 연결된 상태에서 수행한 작업정보를 서버에 유지할 수 있어,
// 영속성이 필요한 작업을 처리하는데 유리하다.
// => 작업 시간:
// = 데이터 전송 시간 + 작업 처리 시간 + 데이터 수신 시간
// 즉 작업을 요청할 때마다 연결할 필요가 없기 때문에 연결하는데 시간이 걸리지 않는다.
// 클라이언트의 작업 상태를 계속 유지할 수 있기 때문에 "stateful" 방식이라 부른다.
//
// => 대표적인 예:
// 게임 서버 연결 - 서버에 한 번 연결되면 게임을 마칠 때까지 데이터를 주고 받는다.
// 화상 통신 - 한 번 연결하면 연결을 끊을 때까지 데이터를 주고 받는다.
// 채팅 서버 - 전용 클라이언트를 이용한 채팅
// 텔렛 - 원격 제어 프로그램
// FTP - 파일 전송 프로그램
// 오프라인 예: 건강보험문의

public class Client0110 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try (Socket socket = new Socket("192.168.1.49", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream())) {

      System.out.println("서버와 연결되었음!");
      String name = null;
      do {
        System.out.print("이름? ");
        name = scan.nextLine();
        out.println(name);
        out.flush();
        String str = in.readLine();
        System.out.println(str);

      } while (!name.equalsIgnoreCase("quit"));


    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}


