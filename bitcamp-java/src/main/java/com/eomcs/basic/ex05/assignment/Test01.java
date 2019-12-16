package com.eomcs.basic.ex05.assignment;
//너무 난잡하게 함 굳이 문자열로 숫자 받을 필요 없음 왜냐면 nextInt는 어차피 스페이스바는 걍 whiteSpace 취급함
import java.util.Scanner;

//입력? 3 7
//3에서 까지의 합은 -입니다.
public class Test01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("입력? ");
    String input = scanner.nextLine();
    String[] inputNumber = input.split(" ");
    
    int num1 = Integer.parseInt(inputNumber[0]);
    int num2 = Integer.parseInt(inputNumber[1]);
    
    int sum = 0;
    
    
    for (int i = num1; i <= num2; i++) {
      sum += i;
    }
    
    System.out.printf("%s에서 %s까지의 합은 %s입니다.", num1, num2, sum);
    
    
    
    
    scanner.close();
  }
}
