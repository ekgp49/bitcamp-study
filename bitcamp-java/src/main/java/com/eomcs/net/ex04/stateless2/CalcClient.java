// stateless 방식 - 계산기 클라이언트를 구분하고 작업결과를 보관하는 방법
package com.eomcs.net.ex04.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    long clientId = 0;
    while (true) {
      try (Scanner keyScan = new Scanner(System.in);
          Socket socket = new Socket("localhost", 8888);
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

        out.writeLong(clientId);

        System.out.print("연산자? ");
        String op = keyScan.nextLine();
        out.writeUTF(op);

        System.out.print("값? ");
        int value = Integer.parseInt(keyScan.nextLine());
        out.writeInt(value);


        clientId = in.readLong();
        int result = in.readInt();
        System.out.println(clientId);
        System.out.println(result);
      }
    }
  }
}


