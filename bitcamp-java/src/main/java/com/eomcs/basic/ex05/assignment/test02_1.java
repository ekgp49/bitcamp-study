package com.eomcs.basic.ex05.assignment;
//이거는 깔끔한대신 입력받는 개수를 맘대로 할수가 없다는 한계가 있다
import java.util.Arrays;
import java.util.Scanner;

public abstract class test02_1 {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("입력 : ");
    int[] input = new int[100];
    
    for(int i = 0; i < 5; i++) {
      input[i] = scan.nextInt();
    }
    
    Arrays.parallelSort(input);
    
    System.out.println("최소: " + input[0] + "\n최대: " + input[input.length - 1]);
    
    scan.close();
  }

}
