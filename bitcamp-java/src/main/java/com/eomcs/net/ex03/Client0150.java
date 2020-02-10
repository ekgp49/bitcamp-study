// 서버와 입출력 테스트 - byte stream
package com.eomcs.net.ex03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0150 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try (Socket socket = new Socket("192.168.1.41", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      System.out.println("서버와 연결되었음!");

      System.out.print("> ");
      scan.nextLine();

      out.println("자주잘대요");
      // out.flush();
      System.out.println("서버에 데이터를 보냈음!");

      String str = in.nextLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}


