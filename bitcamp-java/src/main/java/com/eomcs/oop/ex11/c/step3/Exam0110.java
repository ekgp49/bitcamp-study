// 상수를 활용한 후 : 카테고리를 문자열을 상수로 정의
package com.eomcs.oop.ex11.c.step3;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = Product.appliance_tv;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p2.category = Product.computer_ram;
    p2.name = "삼성모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = Product.book_novel; // <== 잘못된 값을 넣을 수 없다.
    p3.name = "토지";
    p3.price = 18000;


  }
}
