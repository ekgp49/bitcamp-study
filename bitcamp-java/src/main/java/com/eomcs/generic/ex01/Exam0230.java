// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0230 {
  public static void main(String[] args) {
    ArrayList<Object> list1;
    list1 = new ArrayList<Object>();
    
    // ArrayList<Object> 이므로
    // 얘의 메서드의 리턴타입과 파라미터는 Object로 설정된다.
    
    list1.add(new Object());
    list1.add(new String());
    list1.add(new Integer(100));
    list1.add(new Member("asd", 100));
    
    Object obj = list1.get(0);
    String str = (String) list1.get(1);
    
    System.out.println("종료");
  }
}








