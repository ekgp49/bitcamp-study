package com.eomcs.basic.ex04.assignment;


import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("계산기");
    System.out.println("사칙연산만 가능합니다. (+, -, *, /) ex)1+1");


      System.out.print(">");


      String input = scanner.nextLine();
      String[] array = input.split("[+|/|-|*]");
      
      double num1 = Double.parseDouble(array[0]);
      double num2 = Double.parseDouble(array[1]);

      double result = 0;
      String operator = "";
      
      if (input.contains("+")) {
        result = num1 + num2;
        operator = "+";
      } else if (input.contains("-")) {
        result = num1 - num2;
        operator = "-";
      } else if (input.contains("*")) {
        result = num1 * num2;
        operator = "*";
      } else if (input.contains("/")) {
        result = num1 / num2;
        operator = "/";
      };


      System.out.printf("%s %s %s = %s\n", num1, operator, num2, result);


      scanner.close();

    

  }

}
