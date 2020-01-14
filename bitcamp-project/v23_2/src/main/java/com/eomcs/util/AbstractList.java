package com.eomcs.util;

public abstract class AbstractList<E> {
  protected int size;
  
  // size()같은 메서드는 그냥 수퍼클래스에서 일반 메서드로 구현해도 된다.
  public int size() {
    return size;
  }
  
  public abstract void add(E e);
  
  public abstract void add(int index, E e);
  
  public abstract E get(int index);
  
  public abstract E remove(int index);
  
  public abstract E set(int index, E e);
  
  public abstract Object[] toArray();
  
  public abstract E[] toArray(E[] arr);
  
}
