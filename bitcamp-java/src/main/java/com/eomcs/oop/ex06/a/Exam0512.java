// 다형성 - 다형적 변수와 instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0512 {

  public static void main(String[] args) {
    Vehicle v = new Sedan();

    // getClass()?
    // => 레퍼런스가 가리키는 인스턴스의 실제 클래서 정보를 리턴한다
    // => super 클래스인 경우도 검사한다.
    // == 연산자를 사용하여 특정 클래스의 인스턴스인지 확인한다.
    // instanceOf와 다르게 해당 인스턴스의 수퍼클래스는 해당 인스턴스로 인정하지 않는다
    // (콕찝어서 그 클래스의 인스턴스인지 정확하게 확인하는 메서드)
    
    System.out.println(v.getClass() == Sedan.class);
    System.out.println(v.getClass() == Car.class);
    System.out.println(v.getClass() == Vehicle.class);
    
    System.out.println(v.getClass() == Truck.class);
    System.out.println(v.getClass() == Bike.class);
    
  }

}




