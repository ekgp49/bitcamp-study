# 24_4 - `Iterator` 구현체와 로컬 클래스

## 학습 목표

- 로컬 클래스를 사용할 수 있다.
- 로컬 클래스의 용도를 이해한다.
- 논스태틱 중첩 클래스를 사용하여 인터페이스 구현체를 만들 수 있다.


## 실습 소스 및 결과

- src/main/java/com/eomcs/util/AbstractList.java 변경
- src/main/java/com/eomcs/util/Stack.java 변경
- src/main/java/com/eomcs/util/Queue.java 변경

## 실습

### 훈련1. 논스태틱 중첩클래스를 로컬클래스로 만들라.

- AbstractList.java
  - ListIterator 클래스를 논스태틱 중첩 클래스로 변경한다.
  - interator() 메서드를 변경한다.

### 훈련2. QueueIterator 논스태틱 중첩클래스를 로컬클래스로 만들라.

- Queue.java
  - QueueIterator 논스태틱 중첩클래스를 로컬클래스로 만들라.
  - interator() 메서드를 변경한다.

### 훈련3. StackIterator 논스태틱 중첩클래스를 로컬클래스로 만들라.

- Stack.java
  - StackIterator 논스태틱 중첩클래스를 로컬클래스로 만들라.
  - interator() 메서드를 변경한다.
