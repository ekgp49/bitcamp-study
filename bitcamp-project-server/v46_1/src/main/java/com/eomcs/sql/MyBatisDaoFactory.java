package com.eomcs.sql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisDaoFactory {
  InvocationHandler invocationHandler;

  public MyBatisDaoFactory(SqlSessionFactory sqlSessionFactory) {
    this.invocationHandler = (proxy, method, args) -> {

      // 할 일: SqlSession을 이용하여 SQL을 실행한다.
      // 준비물:
      // 1) 실행할 SQL의 namespace와 id
      // 2) select 목록/select 한 개/insert/update/delete 여부
      //
      // 동작원리:
      // 1) 인터페이스명과 메서드명을 이용하여 실행할 SQL 아이디를 알아낸다
      // 2) 리턴타입에 따라 호출할 메서드를 결정한다
      // 3) 파라미터 유무에 따라 메서드에 넘길 항목을 결정한다

      // SQL ID 알아내기
      Class<?> clazz = proxy.getClass(); // 객체로부터 프록시객체의 정보를 알아낸다.
      // 레퍼런스 이름은 class로 할 수 없다. reserved keyword이기 때문
      // 대신 s대신에 비슷해보이는 z를 쓴다.
      Class<?> daoInterface = clazz.getInterfaces()[0];
      // 프록시 객체가 구현한 인터페이스 정보를 알아낸다.
      // 어차피 이 배열엔 인터페이스가 하나밖에 없다
      String interfaceName = daoInterface.getName();
      String sqlId = String.format("%s.%s", interfaceName, method.getName());
      System.out.println(sqlId);

      // 리턴타입에 따라 메서드를 호출한다. List거나 int거나 void거나 객체
      try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
        Class<?> returnType = method.getReturnType();
        if (returnType == List.class) {
          return args == null ? sqlSession.selectList(sqlId)
              : sqlSession.selectList(sqlId, args[0]);
        } else if (returnType == int.class || returnType == void.class) {
          return args == null ? sqlSession.update(sqlId) : sqlSession.update(sqlId, args[0]);
          // update()는 insert(), delete()와 같다.
        } else {
          return args == null ? sqlSession.selectOne(sqlId) : sqlSession.selectOne(sqlId, args[0]);
        }
      }
    };
  }

  // <T> 를 붙인 이유는 리턴타입 T가 클래스 이름이 아니라 타입파라미터인걸 알려주기 위해서이다.
  // 이러면 제네릭 적용 안했을때랑 다르게 createDao()를 호출했을 때 형변환을 안해줘도 됨
  @SuppressWarnings("unchecked")
  public <T> T createDao(Class<T> daoInterface) {
    return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), //
        new Class[] {daoInterface}, invocationHandler);
  }
}
