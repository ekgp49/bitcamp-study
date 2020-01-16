package com.eomcs.util;

public abstract class AbstractList<E> implements List<E> {
  protected int size;

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    
    // local class : 특정 메서드 안에서만 사용하는 중첩클래스라면 그 메서드 안에 둔다.
    // local class는 inner class(인스턴스 멤버)가 아니다. 즉 this를 쓸 수가 없다.
    class ListIterator<T> implements Iterator<T> {
      List<T> list;
      int cursor;

      @SuppressWarnings("unchecked")
      public ListIterator() {
        this.list = (List<T>) AbstractList.this; 
      }

      public T next() {
        return list.get(cursor++);
      }

      public boolean hasNext() {
        return cursor < list.size();
      }
    }
    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에 
    // 앞쪽에 인스턴스 주소를 전달해선 안된다.
    // 즉 this.을 붙여서는 안된다.
    return new ListIterator<>(); 
  }


}
