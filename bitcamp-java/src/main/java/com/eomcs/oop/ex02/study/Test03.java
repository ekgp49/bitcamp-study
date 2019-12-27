package com.eomcs.oop.ex02.study;

public class Test03 {
  public static void main(String[] args) {
    
    Car c1 = new Car();
    c1.name = "트럭1";
    c1.type = Car.OIL;
    c1.color = "빨강";
    c1.speed = 0;
    c1.energy = 80;
    c1.power = 200;
    c1.cleanLevel = 1;
    
    Car c2 = new Car();
    c2.name = "트럭2";
    c2.type = Car.GAS;
    c2.color = "검정";
    c2.speed = 0;
    c2.energy = 60;
    c2.power = 300;
    
    System.out.printf("c1의 잔류량 : %d\n", c1.energy);
    System.out.printf("c2의 잔류량 : %d\n", c2.energy);
    
    GasStation station1 = new GasStation();
    station1.type = Car.OIL;
    station1.name = "강남주유소";
    GasStation station2 = new GasStation();
    station2.type = Car.GAS;
    station2.name = "서초주유소";
    station1.refuel(c1);
    station2.refuel(c2);
    
    System.out.printf("c1의 잔류량 : %d\n", c1.energy);
    System.out.printf("c2의 잔류량 : %d\n", c2.energy);

    GasStation.clean(c1);
    GasStation.clean(c2);
    // static 메서드는 클래스 이름으로 접근해야한다.(권장)
    System.out.println(c1.cleanLevel);
    System.out.println(c2.cleanLevel);
  }
}
