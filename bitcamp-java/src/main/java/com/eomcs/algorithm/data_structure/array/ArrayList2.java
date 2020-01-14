package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList2<E> {

  private static final int DEFAULT_SIZE = 3;

  Object[] list;
  int size;

  public ArrayList2() {
    list = new Object[DEFAULT_SIZE];
  }

  public ArrayList2(int capacity) {
    if (capacity < DEFAULT_SIZE) {
      list = new Object[DEFAULT_SIZE];
    } else {
      list = new Object[capacity];
    }
  }

  public void add(E value) {
    if (size == list.length) {
      grow();
    }
    list[size++] = value;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= size) {
      return;
    }
    if (size == list.length) {
      grow();
    }
    System.arraycopy(list, index, list, index + 1, size++ - index);
    list[index] = value;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    return (E) list[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      return null;
    }
    E oldValue = (E) list[index];
    list[index] = value;
    return oldValue;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    E oldValue = (E) list[index];
    System.arraycopy(list, index + 1, list, index, size-- - (index + 1));
    return oldValue;
  }

  public Object[] toArray() {
    Object[] arr = Arrays.copyOf(list, size);
    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      arr = (E[]) Arrays.copyOf(list, size, arr.getClass());
      return arr;
    }
    System.arraycopy(list, 0, arr, 0, size);
    return arr;
  }
  
  public int size() {
    return this.size;
  }

  private void grow() {
    this.list = Arrays.copyOf(list, newCapacity());
  }

  public int newCapacity() {
    int oldCapacity = list.length;
    return oldCapacity + (oldCapacity >> 1);
  }
}
