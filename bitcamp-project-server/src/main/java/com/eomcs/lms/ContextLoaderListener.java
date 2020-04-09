package com.eomcs.lms;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
// => 이제 데이터 로딩 이상의 일을 해서 ContextLoarderListener로 이름바꿈
//
// @WebListener // 서블릿 컨테이너가 관리
public class ContextLoaderListener implements ServletContextListener {

  static Logger logger = LogManager.getLogger(ContextLoaderListener.class);

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 서블릿 컨테이너가 실행할 때 실행한 사실을 알리기 위하여
    // 모든 ServletContextListener에 대해
    // 이 메서드를 호출한다.
    // => 보통 이 메서드에서는 웹 어플리케이션이 실행되는 동안 사용할 객체를 준비한다.
    // => 이 프로젝트에서는 Spring IoC Container를 준비한다.

    // 준비한 객체를 담을 공용바구니
    try {
      // Spring IoC 컨테이너 준비
      ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);


      // ServletContext는 모든 서블릿이 사용하는 객체를 보관하는 저장소
      // IoC Container는 모든 서블릿이 사용할 수 있어야 한다.
      ServletContext servletContext = sce.getServletContext();
      servletContext.setAttribute("iocContainer", iocContainer);
      printBeans(iocContainer);
      logger.debug("----------------------------------------------");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void printBeans(ApplicationContext appCtx) {
    String[] beanNames = appCtx.getBeanDefinitionNames();
    logger.debug("Spring IoC 컨테이너에 들어있는 객체");
    for (String beanName : beanNames) {
      logger.debug(String.format("%s ===========> %s", beanName,
          appCtx.getBean(beanName).getClass().getName()));
    }

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 주로 서블릿이 사용한 자원을 해체시키는 코드를 둔다.
  }

}
