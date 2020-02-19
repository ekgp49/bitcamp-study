package com.eomcs;

import java.util.ArrayList;
import java.util.List;

public class A {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    list.removeIf(i -> i == 2);

    for (Integer i : list) {
      System.out.println("값:" + i);
    }
  }
}


