// IoC 컨테이너에 객체를 보관하기
package com.eomcs.spring.ioc.ex01.e;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex01/e/application-context.xml");

    SpringUtils.printBeanList(iocContainer);
    System.out.println("실행 완료!");
  }
}


