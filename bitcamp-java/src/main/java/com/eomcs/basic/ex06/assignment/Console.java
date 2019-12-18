package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Console {
  
  static int inputInt(String message) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(message);
    int width = keyScan.nextInt();
    // keyScan.close();
    return width;
  }
  
  @Deprecated // 애노테이션 : 컴파일러나 VM한테 먼가 말하는거임
  static int inputInt() {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int width = keyScan.nextInt();
    // keyScan.close();
    return width;
  }
}
