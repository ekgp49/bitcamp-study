package com.eomcs.lms.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.AppConfig;

@WebServlet(value = "/AppInitServlet", loadOnStartup = 1)
// 클라이언트가 호출 안해도 생성되도록 설정해줌 애노테이션의 한계... url을
// 지정하지 않으면 안생김
public class AppInitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  static Logger logger = LogManager.getLogger(AppInitServlet.class);

  @Override
  public void init() throws ServletException {
    try {
      ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);

      ServletContext servletContext = getServletContext(); // HttpServlet 자체에 getServletContext()
                                                           // 메서드가 있음
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
}
