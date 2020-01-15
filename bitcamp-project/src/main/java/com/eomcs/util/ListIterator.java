package com.eomcs.util;

public class ListIterator<E> implements Iterator<E> {
  List<E> list;
  int cursor;
  
  public ListIterator(List<E> list) {
    this.list = list;
  }
  
  public E next() {
    return list.get(cursor++);
  }
  
  public boolean hasNext() {
    return cursor < list.size();
  }
}
