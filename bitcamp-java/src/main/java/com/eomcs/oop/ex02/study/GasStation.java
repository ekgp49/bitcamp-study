package com.eomcs.oop.ex02.study;

public class GasStation {

  String name;
  int type;
  
  int refuel(Car c) {
    if (c.type != this.type)
      return 0;
    
    int amount = 100 - c.energy;
    c.energy = 100;
    return amount;
  } // 이 클래스에 속한 인스턴스 변수를 사용하기 때문에 인스턴스 메서드로 만듦
    // clean같이 인스턴스 필드를 사용하지 않는 메서드는 굳이 인스턴스 메서드로 만들 필요가 없다.
  static void clean(Car c) {
    c.cleanLevel = 0;
  }
}
