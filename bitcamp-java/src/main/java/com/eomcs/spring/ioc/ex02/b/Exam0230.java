// 객체 생성 - bean의 별명(name)을 알아내기
package com.eomcs.spring.ioc.ex02.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam0230 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/b/application-context.xml");


    SpringUtils.printBeanList(iocContainer);

    // id 없고 별명 많을 경우
    // 첫번째 별명이 id로 사용되고 나미지는 별명으로 사용된다.
    String[] aliases = iocContainer.getAliases("c91");
    for (String aliase : aliases) {
      System.out.println(aliase);
    }
  }

}


