package com.eomcs.util;

// 컬렉션에거 값을 꺼내는 방법 정의
public interface Iterator<E> {
  boolean hasNext();
  E next();
}
