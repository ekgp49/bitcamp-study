// IoC 컨테이너에서 객체 꺼내기 - 예외발생
package com.eomcs.spring.ioc.ex01.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;
import com.eomcs.spring.ioc.ex01.Car;

public class Exam02 {
  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex01/g/application-context.xml");

    SpringUtils.printBeanList(iocContainer);
    // 객체 이름으로 꺼내기 - 존재하지 않는 객체 꺼내기
    // null을 리턴하는게 아니라 예외 발생
    System.out.println(iocContainer.getBean("c2"));
    // 객체 타입으로 꺼내기
    System.out.println(iocContainer.getBean(Car.class));
    System.out.println("실행 완료!");
  }
}


