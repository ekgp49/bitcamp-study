// 객체 생성 - bean의 별명(name)을 알아내기
package com.eomcs.spring.ioc.ex02.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam0250 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/b/application-context.xml");


    SpringUtils.printBeanList(iocContainer);

    String[] aliases = iocContainer.getAliases("c8");
    for (String aliase : aliases) {
      System.out.println(aliase);
    }
    // 여러개의 별명을 지정할 때 공백( ), 콤마(,), 세미콜론(;)을 사용할수 있다.
    // 그 외의 문자는 구분자로 사용할 수 없다. 그냥 일반 문자로 취급함
    // 그래서 c8의 별명은 하나밖에 없다 => c81:c82:c83
  }

}


