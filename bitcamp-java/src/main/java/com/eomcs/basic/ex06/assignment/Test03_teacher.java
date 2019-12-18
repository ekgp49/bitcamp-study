package com.eomcs.basic.ex06.assignment;

//현재 과제와 가장 유사한 결과를 내는 소스를 가져와서 편집한다.
public class Test03_teacher {

  public static void main(String[] args) {
    int width = Console.inputInt();
    if (width % 2 == 0) 
      width--;
    
    int line = 0;
    int spaceSize = width >> 1;

    while (line++ < width) {     //라인
      if(line % 2 == 0) {
        continue; //짝수행 생략!!!!!!!!!
      }
      
      Graphic.drawLine(spaceSize, ' ');
      spaceSize--;
      
      Graphic.drawLine(line, '*');
      
      System.out.println();
    }
  }

}

