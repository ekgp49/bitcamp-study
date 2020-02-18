package com.eomcs;

import java.util.Date;

public class A {

  public static void main(String[] args) {

    System.out.println(new Date(System.currentTimeMillis()));
    System.out.println(new java.sql.Date(System.currentTimeMillis()));
  }
}
