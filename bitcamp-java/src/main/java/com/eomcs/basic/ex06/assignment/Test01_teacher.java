package com.eomcs.basic.ex06.assignment;

public class Test01_teacher {
  public static void main(String[] args) {

    int width = Console.inputInt();
    int line = 0;
    while (line++ < width) {     //라인
      Graphic.drawLine(line, '☆');
      System.out.println();
    }
  }

}
