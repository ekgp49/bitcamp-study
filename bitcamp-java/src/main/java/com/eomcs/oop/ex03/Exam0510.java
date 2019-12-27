// 변수 초기화 - 자동 초기화
package com.eomcs.oop.ex03;

import java.util.Date;

public class Exam0510 {
  static class A {
    static byte b;
    static short s;
    static int i;
    static long l;
    static float f;
    static double d;
    static char c;
    static boolean bool;
    static String str;
    static Date date;
    
    static byte b2;
    static short s2;
    static int i2;
    static long l2;
    static float f2;
    static double d2;
    static char c2;
    static boolean bool2;
    String str2;
    Date date2;
    
  }
  public static void main(String[] args) {
    int c;

    // 클래스 변수는 생성되는 순간 0으로 자동 초기화 된다.
    // byte, short, int, long, char : 0
    // float, double : 0.0
    // boolean : false
    System.out.printf("%d %d %d %d %.1f %.1f %b %s %s \n", 
        A.b, A.s, A.i, A.l, A.f, A.d, A.c, A.bool, A.str, A.date);


    // 인스턴스 변수는 생성되는 순간 0으로 자동 초기화 된다. 
    A obj1 = new A();
    
    System.out.printf("%d %d %d %d %f %f %b %s %s \n", 
        obj1.b2, obj1.s2, obj1.i2, obj1.l2, obj1.f2, obj1.d2, obj1.c2, obj1.bool2, obj1.str2, obj1.date2);
    
    // 로컬 변수는 자동 초기화되지 않는다.
    // 반드시 사용전에 값을 저장해야 한다.
    //System.out.println(c); // 컴파일 오류!
  } 
}




