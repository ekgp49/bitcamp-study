// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0211 {
  public static void main(String[] args) {
    // 만약 <타입명>을 생략한다면
    ArrayList list1; // => ArrayList<?> list;
    list1 = new ArrayList();
    list1 = new ArrayList<Object>();
    list1 = new ArrayList<String>();
    list1 = new ArrayList<Member>();
    
    // ArrayList가 다루는 타입에 상관없이 ArrayList 레퍼런스를 선언하고 싶다면 
    // list1처럼 선언하지 말고 다음과 같이 <?>를 명시하라
    ArrayList<?> list2; // => ArrayList<?> list;
    list2 = new ArrayList(); // 이렇게 사용하지 말고 정확히 제네릭 타입을 지정하라
    list2 = new ArrayList<Object>();
    list2 = new ArrayList<String>();
    list2 = new ArrayList<Member>();
  }
}








