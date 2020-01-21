// 람다(lambda) - 익명 클래스
package com.eomcs.oop.ex12;

public class Exam0120 {

  static interface Player {
    void play();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("실행");
    p1.play();

    Player p2 = () -> {
      System.out.println("실실행행");
    };
    p2.play();
  }
}


