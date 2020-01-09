package com.eomcs.util;

public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList<String> arr = new LinkedList<>();

    arr.add("aaa");
    arr.add("bbb");
    arr.add("ccc");
    arr.add("ddd");
    arr.add("eee");

    arr.add(4, "XXX");
    System.out.println("-------------------");
    print(arr);
  }

  static void print(LinkedList<String> l) {
    for(String a : l.toArray(new String[] {})) {
      System.out.println(a);
    }
  }

}
