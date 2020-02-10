// 서버와 입출력 테스트 - byte stream + buffer
package com.eomcs.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0160 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    try (Socket socket = new Socket("192.168.1.49", 8888);
        Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))) {

      System.out.println("서버와 연결되었음!");

      System.out.print("> ");
      scan.nextLine();

      out.println("자주잘대요");
      // out.flush();
      // byte stream에서 buffer를 사용할 때는 데이터를 보내기 위해 반드시 flush()를 호출해야 한다.
      System.out.println("서버에 데이터를 보냈음!");

      String str = in.nextLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
    scan.close();
  }
}


