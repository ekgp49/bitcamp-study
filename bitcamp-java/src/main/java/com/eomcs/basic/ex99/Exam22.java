package com.eomcs.basic.ex99;

public class Exam22 {
  public static void main(String[] args) {
   //키보드 정보를 가져온다.
    // System.in;
    java.io.InputStream keyboard = System.in; //입력값 변수에 저장
    // java.io.PrintStream console = System.out; // 출력값 변수에 저장

    java.util.Scanner scanner = new java.util.Scanner(keyboard);

    System.out.print("입력>");
    int i1 = scanner.nextInt();
    int i2 = scanner.nextInt();
    int i3 = scanner.nextInt();
    // String s2 = scanner.nextLine();
    
    // String s3 = scanner.nextLine();

    System.out.println("-----------------------------------------------");

    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
  }
}