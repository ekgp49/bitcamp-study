package com.eomcs.design_pattern.observer.after.c;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();

    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());

    car.start();

    car.run();

    car.stop();

    // 업그레이드를 수행한 다음 시간이 지난 후
    // 2) 자동차 시동 걸 때 엔진 오일 검사 기능을 추가한다.
    // => 엔진오일 검사하는 CarObserver(EngineOilCarObserver)을 추가한다.
    // => Car 객체에 등록한다.
  }

}


