// 람다(lambda) - 파라미터
package com.eomcs.oop.ex12;

public class Exam0130 {

  static interface Player {
    void play(String name);
  }

  public static void main(String[] args) {
    Player p1 = (String name) -> System.out.println(name + "실행");
    p1.play("p1");

    Player p2 = (name) -> System.out.println(name + "실행");
    p2.play("p2");

    Player p3 = name -> System.out.println(name + "실행");
    p3.play("p3");

  }
}


