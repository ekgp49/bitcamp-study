// IoC 컨테이너에서 객체 꺼내기
package com.eomcs.spring.ioc.ex01.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;
import com.eomcs.spring.ioc.ex01.Car;

public class Exam01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex01/g/application-context.xml");

    SpringUtils.printBeanList(iocContainer);
    // 객체 이름으로 꺼내기
    System.out.println(iocContainer.getBean("c1"));
    // 객체 타입으로 꺼내기
    System.out.println(iocContainer.getBean(Car.class));
    System.out.println("실행 완료!");
  }
}


