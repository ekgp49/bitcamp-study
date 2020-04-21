package com.eomcs.lms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

// Spring IoC 컨테이너가 탐색할 패키지 설정
// => 지정한 패키지 및 그 하위 패키지를 모두 뒤져서
// @Component 애노테이션이 붙은 클래스를 찾아 객체를 생성한다.
//
@ComponentScan(value = "com.eomcs.lms",
    excludeFilters = {@Filter(type = FilterType.REGEX, pattern = "com.eomcs.lms.web.*"),
        @Filter(type = FilterType.REGEX, pattern = "com.eomcs.lms.admin.*")})

public class AppConfig {

  static Logger logger = LogManager.getLogger(AppConfig.class);

  public AppConfig() {
    logger.debug("AppConfig 객체 생성!");
  }

}


