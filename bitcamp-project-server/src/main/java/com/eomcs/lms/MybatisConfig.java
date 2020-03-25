package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// MyBatis DAO 프록시를 자동 생성할 인터페이스를 지정한다.
@MapperScan("com.eomcs.lms.dao")
@Configuration
public class MybatisConfig {
  static Logger logger = LogManager.getLogger(MybatisConfig.class);

  public MybatisConfig() {
    logger.debug("MybatisConfig 객체 생성!");
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext appCtx)
      throws Exception {
    // log4j2 활성화시키기
    LogFactory.useLog4J2Logging();

    // Spring IoC 컨테이너 용으로 mybatis에서 따로 제작한 SqlSessionFactoryBean이다. 얘는 빌더임
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    sqlSessionFactoryBean.setMapperLocations(//
        appCtx.getResources("classpath:com/eomcs/lms/mapper/*Mapper.xml"));
    return sqlSessionFactoryBean.getObject();
  }
}
