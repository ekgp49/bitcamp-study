package com.eomcs.basic.ex04;

public class Exam92 {
  
  public static void main(String[] args) {
    float f = 3.14f;
    
    double d = 3.14;
    
    int i;
    long l;
    
//    i = f;
//    i = d;

//    l = f;
//    l = d;
    
    i = (int) f;
    System.out.println(i);
    i = (int) d;
    System.out.println(i);
    
    l = (long) f;
    l = (long) d;
  }
}