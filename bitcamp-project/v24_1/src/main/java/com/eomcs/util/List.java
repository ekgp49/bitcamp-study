package com.eomcs.util;

// 목록 객체의 사용 규칙을 따로 정의
// 문법 : interface 규칙명 {...}
public interface List<E> {

  // 사용 규칙(호출할 메서드 시그너처 형식)이기 때문에 모든 메서드는 추상 메서드이다.
  // 또한 규칙은 공개되어야 하기 때문에 모든 메서드는 public 이다.
  // => 문법
  //     public abstract 리턴타입 메서드명(파라미터, ...);
  //        => public 생략 가능
  //           => abstract도 생략 가능
  /*public abstract*/ void add(E e);

  /*public*/ abstract void add(int index, E e);

  public /*abstract*/ E get(int index);

  E remove(int index);

  E set(int index, E e);

  Object[] toArray();

  E[] toArray(E[] arr);
  
  int size();
  
  // 내부에 보관된 값을 꺼내주는 메서드 규칙을 추가한다.
  // => 값을 저장하는 방식에 따라 구현 방법이 다르기 때문에
  //    서브 클래스가 반드시 구현해야 하는 추상 메서드이다.
  Iterator<E> iterator();

}
