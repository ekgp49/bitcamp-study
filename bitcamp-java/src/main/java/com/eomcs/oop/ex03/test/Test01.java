package com.eomcs.oop.ex03.test;

import com.eomcs.oop.ex03.test.sub.A;

class Score {
  static int count;
  String name;
  int kor;
  int math;
  int sum;
  float avr;

  public Score() {
    // 기본 생성자 설정
  }
  
  Score(String name, int math, int kor) {
    System.out.println("Score() - 2");
    this.name = name;
    this.math = math;
    this.kor = kor;
    this.compute();
  }
  
  void Score() {
    System.out.println("Score()");
  }

  static void increase() {
    Score.count++;
  }

  void compute() {
    this.sum = this.kor + this.math;
    this.avr = this.sum / 2f;
  }
}

public class Test01 {
  public static void main(String[] args) {
    Score s1 = new Score();
    System.out.println("-----------------");
    s1.name = "강";
    s1.kor = 100;
    s1.math = 100;
    s1.compute();
    Score.increase();

    Score s2 = new Score();
    System.out.println("---------------");
    s2.name = "광";
    s2.kor = 90;
    s2.math = 100;
    s2.compute();
    Score.increase();
  
    Score s3 = new Score("응가", 100, 80);
    System.out.println(s3.name);
  }
  
}
