// 람다(lambda) - 메소드 1개
package com.eomcs.oop.ex12;

public class Exam0210 {

  static interface Player {
    void play();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("실행");

    p1.play();
  }
}


