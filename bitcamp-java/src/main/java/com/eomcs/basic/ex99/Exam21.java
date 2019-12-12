package com.eomcs.basic.ex99;

public class Exam21 {
  public static void main(String[] args) {
   //키보드 정보를 가져온다.
    // System.in;
    java.io.InputStream keyboard = System.in; //입력값 변수에 저장
    // java.io.PrintStream console = System.out; // 출력값 변수에 저장

    java.util.Scanner scanner = new java.util.Scanner(keyboard);

    String s1 = scanner.nextLine();

    String s2 = scanner.nextLine();
    
    String s3 = scanner.nextLine();

    System.out.println("-----------------------------------------------");

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }
}