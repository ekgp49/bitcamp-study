package com.eomcs.basic.ex06.assignment;

public class Test02_teacher {
  public static void main(String[] args) {

    int width = Console.inputInt();
    int line = 0;
    while (line++ < width) {     //라인
      Graphic.drawLine(line);
      System.out.println();
    }

    line--; //아님 line = width;
    while (--line > 0) {
      Graphic.drawLine(line);
      System.out.println();
    }
  }

}


