package com.eomcs.basic.ex04;

public class Exam81 {
  
  public static void main(String[] args) {
    int a;
    
    {
      a = 100;
      
      int b;
      b = 200;
    }
    
//    b = 300;
    {
//      int a;
      int b; //ok
    }
    
    if (true) {
//      int a = 200;
      int b = 200;
    }
//    b = 300;
  }
}