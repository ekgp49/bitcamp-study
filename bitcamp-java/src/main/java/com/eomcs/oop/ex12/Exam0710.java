// 메서드 레퍼런스 - 생성자 레퍼런스
package com.eomcs.oop.ex12;

import java.util.ArrayList;
import java.util.List;

public class Exam0710 {

  static interface ListFactory {
    List create();
  }

  public static void main(String[] args) {

    ListFactory f1 = ArrayList::new; // new ArrayList();

    // 인터페이스의 메서드를 호출하면 지정된 클래스의 인스턴스를 만든 후 생성자를 호출한다.
    List list = f1.create();

    System.out.println(list instanceof ArrayList);
    System.out.println(list.getClass().getName());
  }
}


