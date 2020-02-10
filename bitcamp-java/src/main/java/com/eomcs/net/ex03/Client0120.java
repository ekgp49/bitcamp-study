// 서버와 입출력 테스트 - byte 배열 보내고 받기
package com.eomcs.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0120 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try (Socket socket = new Socket("localhost", 8888);

        // 서버랑 데이터를 주고 받을 수 있도록 입출력 스트림 객체를 준비한다.
        // => 출력 스트림 객체를 준비하기
        OutputStream out = socket.getOutputStream();

        // => 입력 스트림 객체를 준비하기
        InputStream in = socket.getInputStream()) {

      System.out.println("서버와 연결되었음!");

      // 서버에 데이터를 보내기 전에 잠깐 멈춤
      System.out.print(">");
      scan.nextLine();

      // 서버에 보낼 바이트 배열 준비
      byte[] bytes = new byte[100];
      for (int i = 0; i < 100; i++) {
        bytes[i] = (byte) i;
      }
      // 서버에게 데이터 보내기
      // - 보통 클라이언트 쪽에서 먼저 서버로 데이터를 보낸다.
      // - 실제 write()는 소켓의 내부 버퍼로 출력한다.
      // 따라서 write() 호출 후 즉시 리턴될 것이다.
      out.write(bytes);

      // out.flush();
      System.out.println("서버에 데이터를 보냈음!");
      // 서버의 응답을 받는다.
      // - 서버가 응답을 할 때까지 리턴하지 않는다.
      // 즉 blocking 모드로 작동한다.
      byte[] buf = new byte[100];
      int size = in.read(buf);
      System.out.printf("서버가 보낸 바이트 배열의 크기: %d\n", size);

      for (int i = 0; i < size; i++) {
        if (i > 0 && i % 20 == 0) {
          System.out.println();
        }
        System.out.printf("%c ", buf[i]);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}


