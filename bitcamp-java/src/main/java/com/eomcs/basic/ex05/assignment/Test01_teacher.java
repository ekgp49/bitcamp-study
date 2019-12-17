package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test01_teacher {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in); 
    //System.in처럼 안에 들어있는걸 dependency 라고 부름 dependency injection (DI)
    //DI를 자동화 시키놓은게 스프링
    System.out.print("입력? ");
    int start = keyScan.nextInt();
    int end = keyScan.nextInt();
   
    int sum = 0;
//    int no = start;
//    while (no <= end) {
//      sum += no;
//      no++;
//    }
    
    for(int no = start; no <= end; no++) {
      sum += no;
    }
    
    System.out.printf("%d에서 %d까지의 합은 %d입니다.\n", start, end, sum);
    
    keyScan.close();
  }
}
