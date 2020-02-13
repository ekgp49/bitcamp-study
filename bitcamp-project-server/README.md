# 33 - 동일한 자원으로 더 많은 클라이언트의 요청을 처리하는 방법

## 학습 목표

- `Stateless` 통신 방식으로 바꿀 수 있다.
- `Stateless` 통신 방식의 특징과 장단점을 이해한다
   
## 실습 소스 및 결과
- src/main/java/com/eomcs/lms/ServerApp.java 변경

### 훈련 1: `Stateful` 통신 방식을 `Stateless` 통신 방식으로 바꿔라.

- ServerApp.java
    - 클라이언트와 연결된 후 여러 번 명령을 처리하는 로직을 한 번만 처리하도록 변경한다.

#### 실행 결과

먼저 `ServerApp`을 실행한다.
```
이전과 실행 결과는 같다.
```
