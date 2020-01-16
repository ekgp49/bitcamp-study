package com.eomcs.util;

public abstract class AbstractList<E> implements List<E> {
  protected int size;

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    return this.new ListIterator<>(); 
  }

  class ListIterator<T> implements Iterator<T> {
    List<T> list;
    int cursor;

    @SuppressWarnings("unchecked")
    public ListIterator() {
      this.list = (List<T>) AbstractList.this; // 타입캐스팅 해줘야함...
    }

    public T next() {
      return list.get(cursor++);
    }

    public boolean hasNext() {
      return cursor < list.size();
    }
  }
}
