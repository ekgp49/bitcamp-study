package com.eomcs.basic.ex06.assignment;

public class Graphic {
  static void drawLine(int length) {
    int x = 0;
    while (x++ < length) {      //별
      System.out.print("*");  
    }
  }
  
  static void drawLine(int length, char ch) {
    int x = 0;
    while (x++ < length) {      //별
      System.out.print(ch);  
    }
  }
}
