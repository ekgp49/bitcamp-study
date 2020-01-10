// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0212 {
  public static void main(String[] args) {
    ArrayList<Object> list1;
    list1 = new ArrayList();
    list1 = new ArrayList<Object>();
    //list1 = new ArrayList<String>(); // 컴파일 오류
    //list1 = new ArrayList<Member>(); // 컴파일 오류
  }
}








