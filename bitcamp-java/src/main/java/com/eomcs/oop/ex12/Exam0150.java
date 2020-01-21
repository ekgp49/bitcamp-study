// 람다(lambda) - 파라미터
package com.eomcs.oop.ex12;

public class Exam0150 {

  static interface Player {
    void play(String name, int age);
  }

  public static void main(String[] args) {
    Player p1 = (String name, int age) -> System.out.printf("Hello! %s(%d)\n", name, age);
    p1.play("p1", 20);

    Player p2 = (name, age) -> System.out.printf("Hello! %s(%d)\n", name, age);
    p2.play("p2", 30);

    // Player p3 = name, age -> System.out.printf("Hello! %s(%d)\n", name, age);
    // p3.play("p3", 40); ;
    // 파라미터가 두개 이상이면 괄호 생략 불가

  }
}


