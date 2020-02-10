// 서버와 입출력 테스트 - character stream
package com.eomcs.net.ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try (Socket socket = new Socket("192.168.1.49", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream())) {

      System.out.println("서버와 연결되었음!");

      System.out.print("> ");
      scan.nextLine();

      out.println("ABC가각간");
      // out.flush();
      // character stream 클래스의 경우 출력데이터를 내부버퍼에 저장하고 있다가
      // flush()을 호출했을 때 비로소 출력을 수행한다.
      System.out.println("서버에 데이터를 보냈음!");

      String str = in.readLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}


