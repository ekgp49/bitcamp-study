package com.eomcs.util;

public class List<E> {
  protected int size;
  
  public int size() {
    return size;
  }
  
  public void add(E e) {
    // ArrayList나 LinkedList는 동작 방법이 다르기 때문에
    // 여기서 구현할 필요가 없다.
  }
  
  // 이하 동일
  public void add(int index, E e) {
    
  }
  
  public E get(int index) {
    return null;
  }
  
  public E remove(int index) {
    return null;
  }
  
  public E set(int index, E e) {
    return null;
  }
  
  public Object[] toArray() {
    return null;
  }
  
  public E[] toArray(E[] arr) {
    return null;
  }
  
}
