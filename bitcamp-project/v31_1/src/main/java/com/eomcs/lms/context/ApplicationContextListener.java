package com.eomcs.lms.context;

// 애플리케이션의 상태가 변경되었을 때
// 호출할 메서드 규칙을 정의한다.
// 즉 애플리케이션 상태 변경에 대해 보고를 받을 옵저버규칙을 정의한다
// 보통 옵저버를 리스너라 부르기도 한다.
public interface ApplicationContextListener {
  void contextInitialized();

  void contextDestroyed();
}
