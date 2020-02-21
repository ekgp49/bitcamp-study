# 37_1 Application Server 구조로 변경: 규칙1에 따라 통신하는 클라이언트 만들기

## 학습목표

- Application Server 아키텍쳐의 구성과 특징을 이해한다.
- 통신 프로토콜 규칙에 따라 동작하는 클라이언트를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/dao/mariadb/BoardDaoImpl.java 변경
- src/main/java/com/eomcs/lms/dao/mariadb/LessonDaoImpl.java 변경
- src/main/java/com/eomcs/lms/dao/mariadb/MemberDaoImpl.java 변경
- src/main/java/com/eomcs/lms/ClientApp.java 변경

## 실습  

### 훈련1: 한 개의 DB 커넥션 객체를 DAO 모두가 공유하여 사용하라.

- com.eomcs.lms.ClientApp 변경한다.
- com.eomcs.lms.dao.mariadb.XxxDaoImpl 변경한다.

