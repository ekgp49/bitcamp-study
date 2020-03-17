package com.eomcs.lms;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.sql.MyBatisDaoFactory;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;
import com.eomcs.util.ApplicationContext;
import com.eomcs.util.Component;
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
      // ApllicationContext에서 자동으로 생성하지 못하는 객체는 따로 생성하여 맵에 보관한다.
      HashMap<String, Object> beans = new HashMap<>();

      // Mybatis 객체 준비
      InputStream inputStream = Resources.getResourceAsStream(//
          "com/eomcs/lms/conf/mybatis-config.xml");

      // 트랜잭션 제어를 위해 오리지널 객체를 프록시 객체에 담아 사용한다.
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryProxy(//
          new SqlSessionFactoryBuilder().build(inputStream));
      beans.put("sqlSessionFactory", sqlSessionFactory);

      // DAO 프록시 객체를 생성해줄 팩토리를 준비
      MyBatisDaoFactory daoFactory = new MyBatisDaoFactory(sqlSessionFactory);

      // 서비스 객체가 사용할 DAO를 준비한다.
      beans.put("lessonDao", daoFactory.createDao(LessonDao.class));
      beans.put("boardDao", daoFactory.createDao(BoardDao.class));
      beans.put("memberDao", daoFactory.createDao(MemberDao.class));
      beans.put("photoBoardDao", daoFactory.createDao(PhotoBoardDao.class));
      beans.put("photoFileDao", daoFactory.createDao(PhotoFileDao.class));

      // 트랜잭션 관리자 준비
      PlatformTransactionManager txManager = new PlatformTransactionManager(//
          sqlSessionFactory);
      beans.put("txManager", txManager);

      // IoC 컨테이너 준비
      ApplicationContext appCtx = new ApplicationContext("com.eomcs.lms", beans);
      context.put("iocContainer", appCtx);

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
