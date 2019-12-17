package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test02_teacher {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    System.out.print("입력? ");
    for (int i = 0; i < 5; i++) {
      int no = keyScan.nextInt();
     
      if (no < min) {
        min = no;
      } else if (no > max) {
        max = no;
      }
    }

    System.out.printf("최소값 : %d\n", min);
    System.out.printf("최대값 : %d", max);

    keyScan.close();
  }

}
