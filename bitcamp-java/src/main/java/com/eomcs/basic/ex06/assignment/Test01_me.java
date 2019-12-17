package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test01_me {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int length = scan.nextInt();
    String stars = "";
    int count = 0;
    while (count < length) {
      stars += "*";
      count++;
      System.out.println(stars);
    }
    
    scan.close();
  }
}
