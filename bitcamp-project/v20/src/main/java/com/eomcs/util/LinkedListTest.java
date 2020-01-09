package com.eomcs.util;

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    
    System.out.println(list.set(0, "xxx"));
    System.out.println("------------------");
    print(list);
  }
  
  static void print(LinkedList<String> list) {
    String[] arr = list.toArray(new String[list.size()]);
    for(String s : arr) {
      System.out.println(s);
    }
  }
}
