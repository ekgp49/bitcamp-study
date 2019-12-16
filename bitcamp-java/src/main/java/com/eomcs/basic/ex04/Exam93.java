package com.eomcs.basic.ex04;

public class Exam93 {
  
  public static void main(String[] args) {
    byte b = 127;
    short s = 32767;
    int i = 21_0000_0000;
    long l = 922_0000_0000_0000_0000L;
    float f = 3.14f;
    double d = 3.14;
    
    l = i;
    i = s;
    s = b;
    
    i = (int) l;
    System.out.println(i);
    s = (short) i;
    System.out.println(s);
    b = (byte) s;
    System.out.println(b);
    
    
    i = 65;
    char c = (char) s;

    System.out.println(c);
    
    boolean bool;
//    bool = b;
//    bool = s;
//    bool = i;
//    bool = l;
//    bool = f;
//    bool = l;
//    bool = c;
    
//    bool = "true";
//    i = "10";
//    c = "rksk";
//    f = "3.14f";
//      i = bool;
  }
}