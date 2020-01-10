// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import com.eomcs.generic.ex01.Exam0224.A;
import com.eomcs.generic.ex01.Exam0224.B1;

public class Exam0231 {
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  
  public static void main(String[] args) {
    ArrayList<B1> list1;
    list1 = new ArrayList<>();

//    list1 = new ArrayList<C>();
    
    // ArrayList의 항목 타입을 B1으로 지정했기 때문에 ArrayList의 파라미터와 리턴타입은 B1으로 지정된다
    
//    list1.add(new Object());
//    list1.add(new String());
//    list1.add(new Integer(100));
//    list1.add(new Member("asd", 100));
    list1.add(new B1());
    list1.add(new C());
    
    System.out.println("종료");
  }
}








