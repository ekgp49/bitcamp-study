package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//입력? 3 7
//3에서 까지의 합은 -입니다.
public class Test01_1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("입력? ");

    int[] input = new int[2];
    int sum = 0;
    
    for(int i = 0; i < 2; i++) {
      input[i] = scanner.nextInt();
    }
    
    
    for (int i = input[0]; i <= input[1]; i++) {
      sum += i;
    }
    
    
    System.out.printf("%s에서 %s까지의 합은 %s입니다.", input[0], input[1], sum);
    
    
    
    
    scanner.close();
  }
}
