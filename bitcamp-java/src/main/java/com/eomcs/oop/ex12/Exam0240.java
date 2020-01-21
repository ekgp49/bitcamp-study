// 람다(lambda) - 람다문법은 추상 메소드 한개짜리 인터페이스만 가능
package com.eomcs.oop.ex12;

public class Exam0240 {

  static abstract class Player {
    public abstract void play();
  }

  public static void main(String[] args) {
    Player p1 = () -> System.out.println("실행"); // 컴파일 오류!

    p1.play();
  }
}


