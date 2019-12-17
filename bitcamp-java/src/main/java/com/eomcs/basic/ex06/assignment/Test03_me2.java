package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test03_me2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("밑변 길이? ");

    int l = scan.nextInt();
    String stars = "";
    int space = 0;
    int star = 0;
    int m = 1;


    while(2 * m-1 <= l) {
      space = 0;
      star = 0;
      while (space <  (l-(2*(m-1))-1)/2) {
        System.out.print(" ");
        space++;
      }

      while (star < 2 * m - 1) {
        System.out.print("*");
        star++;
      }
      m++;
  
      System.out.println();
    }


    System.out.println(space);
    System.out.println(l);
    System.out.println(m);
    //    2행 :while ()
    //      System.out.println(stars);
    //    
    //    3행 :while ()
    //      System.out.println(stars);
  }
}

