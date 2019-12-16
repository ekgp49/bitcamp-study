package com.eomcs.basic.ex04.v01;

import java.util.Arrays;
import java.util.Scanner;

public abstract class test03 {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    
    System.out.print("입력 : ");
    int[] input = new int[100];
    
    for(int i = 0; i < 100; i++) {
      input[i] = scan.nextInt();
    }
    
    Arrays.parallelSort(input);
    
    System.out.println("최소: " + input[0] + "\n최대: " + input[4]);
    
    scan.close();
  }

}
