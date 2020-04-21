package com.eomcs.lms.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Spring IoC 컨테이너가 탐색할 패키지 설정
// => 지정한 패키지 및 그 하위 패키지를 모두 뒤져서
// @Component 애노테이션이 붙은 클래스를 찾아 객체를 생성한다.
//
@ComponentScan(value = "com.eomcs.lms.admin")
@EnableWebMvc
public class AdminWebConfig {

  static Logger logger = LogManager.getLogger(AdminWebConfig.class);

  public AdminWebConfig() {
    logger.debug("AdminWebConfig 객체 생성!");
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver("/WEB-INF/admin/", ".jsp");
    return vr;
  }

  @Bean
  public MultipartResolver multipartResolver() {
    // 스프링 방식으로 파일 업로드를 처리하고 싶다면,
    // 이 메서드를 통해 MultipartResolver 구현체를 생성해야 한다.
    CommonsMultipartResolver mr = new CommonsMultipartResolver();
    mr.setMaxUploadSize(10000000);
    mr.setMaxInMemorySize(2000000);
    mr.setMaxUploadSizePerFile(5000000);
    return mr;
  }
  // Spring IoC 컨테이너에 수동으로 객체를 등록하고 싶다면,
  // 그 객체를 만들어 주는 팩토리 메서드를 정의해야 한다.
  // => 단 메서드 선언부에 @Bean 애노테이션을 붙여야 한다.
  // => 그래야만 Spring IoC 컨테이너는
  // 이 메서드를 호출하고 그 리턴 값을 보관한다.
}


