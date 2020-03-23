package com.eomcs.spring.ioc.ex10.b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.eomcs.spring.ioc.ex10.Car;

// @Component // 이렇게 해도 되긴 하는데 설정파일은 그냥 Configuration 애노테이션을 쓴다.
@Configuration // 설정파일임을 강조하기
// AppConfig 클래스가 스프링 설정 정보를 갖고 있는 클래스임을 선포한다!
// 그러면 AnnotationConfigApplicationContext 에서
// 이 클래스를 찾아 적절한 작업을 수행할 것이다.
public class AppConfig {
  @Bean
  public Car car2() {
    Car c = new Car(null);
    c.setMaker("비트자동차");
    c.setModel("티코");
    c.setCc(890);
    c.setAuto(true);
    return c;
  }

  @Bean
  public Car car3() {
    Car c = new Car(null);
    c.setMaker("비트자동차");
    c.setModel("티코");
    c.setCc(890);
    c.setAuto(true);
    return c;
  }

}


