package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test03_me {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("밑변 길이? ");

    int l = scan.nextInt();
    String stars;
    // 총 행 = (l + 1) / 2;
    
    for (int i = 0; i < (l + 1) / 2; i++) {
      stars = "";
      for (int j = i; j < (l - 1) / 2; j++) {
        stars += " ";
      }
      for(int k = 0; k < 2 * i + 1; k++) {
        stars += "*";
      }
      System.out.println(stars);
      
    }
  }
}
