# 53_1 - Log4j 1.2.x 를 사용하여 애플리케이션 로그 처리하기

애플리케이션의 실행 상태를 확인하고 싶을 때 보통 `System.out.println()`을 사용하여 변수의 값이나 
메서드의 리턴 값, 객체의 필드 값을 출력한다. 
이 방식의 문제는 개발을 완료한 후 이런 코드를 찾아 제거하기가 매우 번거롭다는 것이다. 
또한 콘솔 출력이 아닌 파일이나 네트웍으로 출력하려면 별개의 코드를 작성해야 한다.
이런 문제점을 해결하기 위해 나온 것이 `Log4j`라는 라이브러리이다.
개발 중에는 로그를 자세하게 출력하고 개발이 완료된 후에는 중요 로그만 출력하도록 조정하는 기능을 제공한다.
로그의 출력 형식을 지정할 수 있다. 출력 대상도 콘솔, 파일, 네트워크, DB 등 다양하게 지정할 수 있다.

## 학습목표

- Log4j 1.2.x 를 설정하고 이용하는 방법

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/DatabaseConfig.java 변경
- src/main/java/com/eomcs/lms/service/impl/PhotoBoardServiceImpl.java 변경

## 실습  

### 훈련1: Log4j 1.2.x 라이브러리를 추가한다.

- com.eomcs.lms.DatabaseConfig 변경
  - @Transactional 애노테이션 기능을 활성화시키기 위해서 
    @EnableTransactionManagement 애노테이션을 추가로 선언한다.

#### @EnableTransactionManagement 

메서드에 @Transactional 이 붙어 있으면 
해당 메서드를 트랜잭션으로 묶기 위해  
프록시 객체를 자동 생성한다.
  

### 훈련2: @Transactional 애노테이션으로 트랜잭션을 제어하라.

- com.eomcs.lms.service.impl.PhotoBoardServiceImpl 변경
  - TransactionTemplate을 사용하는 대신에 @Transactional 애노테이션을 붙인다.
  - add(), update(), delete()을 변경한다.
  
