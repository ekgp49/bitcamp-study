package com.eomcs.basic.ex05.assignment;

import java.util.Arrays;
import java.util.Scanner;

//입력? 7 4 12 8 9
//최소값 : 4
//최대값 : 12
public class test02 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("입력? ");

    String input = scanner.nextLine();
    String[] inputContents;
    inputContents = input.split(" ");
    
    int[] inputNumbers = new int[inputContents.length]; 
    
    for(int i = 0; i < inputContents.length; i++) {
      inputNumbers[i] = Integer.parseInt(inputContents[i]);
    }
    
    Arrays.parallelSort(inputNumbers);
    
    System.out.printf("최소값 : %s\n최대값 : %s", inputNumbers[0], 
        inputNumbers[inputNumbers.length - 1]);
    
    scanner.close();
  }

}
