package com.eomcs.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  Scanner input;
  
  public Prompt(Scanner input) {
    this.input = input;
  }
  
  public String inputString(String lable) {
    System.out.print(lable);
    return input.nextLine();
  }
  
  // update 할 때
  public String inputString(String lable, String defaultValue) {
    System.out.print(lable);
    String value = input.nextLine();
    if (value.length() == 0) {
      return defaultValue;
    }
    return value;
  }
  
  public int inputInt(String lable) {
    System.out.print(lable);
    return Integer.parseInt(input.nextLine());
  }
  
  public int inputInt(String lable, int defaultValue) {
    System.out.print(lable);
    String value = input.nextLine();
    if (value.length() == 0) {
      return defaultValue;
    }
    return Integer.parseInt(value);
  }
  
  public Date inputDate(String lable) {
    System.out.print(lable);
    return Date.valueOf(input.nextLine());
  }
  
//  public Date inputDate(String lable, Date defaultValue) {
//    System.out.print(lable);
//    String value = input.nextLine();
//    if (value.length() == 0) {
//      return defaultValue;
//    }
//    return Date.valueOf(value);
//  }
  
}
