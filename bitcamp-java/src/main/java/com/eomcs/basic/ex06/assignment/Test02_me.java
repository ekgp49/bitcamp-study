package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test02_me {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int length = scan.nextInt();
    int count = 0;
    int num = 0;

    while (count < length) {
      count++;
      num = count;
      while (num > 0) {
        num--;
        System.out.print("*");
      }
      System.out.println();
    }
    
    count = length;
    while (count > 0) {
      count--;
      num = count;
      while (num > 0) {
        num--;
        System.out.print("*");
      }
      System.out.println();
    }


  }
}
