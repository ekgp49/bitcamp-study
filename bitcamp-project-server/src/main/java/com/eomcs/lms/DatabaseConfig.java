package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Spring IoC 컨테이너가 이 클래스를 Java Config로 자동 인식하러면
// 다음 태그를 붙여야 한다.
// 단, 이 클래스가 @ComponentScan에서 지정한 패키지 안에 있어야 한다.
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:com/eomcs/lms/conf/jdbc.properties")
public class DatabaseConfig {
  static Logger logger = LogManager.getLogger(DatabaseConfig.class);

  @Value("${jdbc.driver}")
  String jdbcDriver;

  @Value("${jdbc.url}")
  String jdbcUrl;

  @Value("${jdbc.username}")
  String jdbcUsername;

  @Value("${jdbc.password}")
  String jdbcPassword;

  public DatabaseConfig() {
    logger.debug("DatabaseConfig 객체 생성!");
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(jdbcDriver);
    ds.setUrl(jdbcUrl);
    ds.setUsername(jdbcUsername);
    ds.setPassword(jdbcPassword);
    return ds;
  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
