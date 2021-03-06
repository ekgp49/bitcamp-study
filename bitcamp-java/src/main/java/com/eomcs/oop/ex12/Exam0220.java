// 람다(lambda) - 메소드 다수
package com.eomcs.oop.ex12;

public class Exam0220 {

  static interface Player {
    void play();

    default void stop() {}

    static String info() {
      return "ok!";
    }
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("실행");

    p1.play();
  }
}


