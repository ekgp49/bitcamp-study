// 상수를 활용하기 전 : 카테고리를 문자열로 받기
package com.eomcs.oop.ex11.c.step2;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = "appliance/tv";
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p2.category = "computer/ram";
    p2.name = "삼성모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = "book/novul"; // <= book/novel인데 오타남
    p3.name = "토지";
    p3.price = 18000;

    // 제품의 카테고리 값을 문자열로 다루면
    // 따로 주석을 다룰 필요가 없어 좋다.
    // 단 문자열에 오타가 들어가면 프로그램이 의도대로 동작하지않을 것이다

  }
}
