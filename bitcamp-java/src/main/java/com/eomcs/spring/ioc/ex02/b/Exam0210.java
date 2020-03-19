// 객체 생성 - bean의 별명(name)을 알아내기
package com.eomcs.spring.ioc.ex02.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam0210 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/b/application-context.xml");


    SpringUtils.printBeanList(iocContainer);

    String[] aliases = iocContainer.getAliases("c5");
    for (String aliase : aliases) {
      System.out.println(aliase);
    }
  }

}


