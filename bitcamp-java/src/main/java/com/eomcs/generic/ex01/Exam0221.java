// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0221 {
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  public static void main(String[] args) {
    m1(new ArrayList());
    m1(new ArrayList<Object>());
    // Object만 가능. 하위클래스도 안됨
    
//    m1(new ArrayList<A>());
//    m1(new ArrayList<B1>());
//    m1(new ArrayList<B2>());
//    m1(new ArrayList<C>());
    

  }

  static void m1(ArrayList<Object> list) {

  }
}








