package com.eomcs.lms;

import java.lang.reflect.Method;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.util.RequestHandler;
import com.eomcs.util.RequestMapping;
import com.eomcs.util.RequestMappingHandlerMapping;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
// => 이제 데이터 로딩 이상의 일을 해서 ContextLoarderListener로 이름바꿈
//
public class ContextLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // Spring IoC 컨테이너 준비
      ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);

      context.put("iocContainer", appCtx);
      printBeans(appCtx);

      // @ComponentAnnotation이 붙은 객체 찾기
      RequestMappingHandlerMapping handlerMapper = new RequestMappingHandlerMapping();
      String[] beanNames = appCtx.getBeanNamesForAnnotation(Component.class);
      for (String beanName : beanNames) {
        Object component = appCtx.getBean(beanName);
        Method method = getRequestHandler(component.getClass());
        if (method != null) {
          RequestHandler requestHandler = new RequestHandler(method, component);
          handlerMapper.addHandler(requestHandler.getPath(), requestHandler);
        }
      }

      // serverApp와 공유한다.
      context.put("handlerMapper", handlerMapper);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void printBeans(ApplicationContext appCtx) {
    String[] beanNames = appCtx.getBeanDefinitionNames();
    System.out.println("Spring IoC 컨테이너에 들어있는 객체");
    for (String beanName : beanNames) {
      System.out.printf("%s ===========> %s\n", beanName,
          appCtx.getBean(beanName).getClass().getName());
    }

  }

  private Method getRequestHandler(Class<?> type) {
    // 클라이언트 명령을 처리할 메서드는 public이기 때문에
    // 클래스에서 public 메서드만 조사한다.
    Method[] methods = type.getMethods();
    for (Method m : methods) {
      // 메서드에 @RequestMappingAnnotation이 붙었는지 검사한다.
      RequestMapping anno = m.getAnnotation(RequestMapping.class);
      if (anno != null) {
        return m;
      }
    }
    return null;
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}

}
