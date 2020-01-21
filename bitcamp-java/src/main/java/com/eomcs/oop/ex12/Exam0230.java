// 람다(lambda) - 메소드 다수
package com.eomcs.oop.ex12;

public class Exam0230 {

  static interface Player {
    void play();

    void stop();
  }

  public static void main(String[] args) {
    // 람다는 인터페이스 메서드 한개짜리만 가능
    Player p1 = () -> System.out.println("실행"); // 컴파일 오류!
    p1.play();
  }
}


