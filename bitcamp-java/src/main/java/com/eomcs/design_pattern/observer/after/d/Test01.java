package com.eomcs.design_pattern.observer.after.d;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();

    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());
    car.addCarObserver(new BreakOilCarObserver());

    car.start();

    car.run();

    car.stop();

    // 업그레이드를 수행한 다음 시간이 지난 후
    // 3) 자동차 시동 걸 때 브레이크 오일 검사 기능을 추가한다.
    // => 브레이크 오일을 검사하는 옵저버(BreakOilCarObserver)을 정의하고 Car에 등록한다.
  }

}


