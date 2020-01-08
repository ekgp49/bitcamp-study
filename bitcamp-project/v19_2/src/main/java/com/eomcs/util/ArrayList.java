package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
  Object[] list;
  int size;
  private static final int DEFAULT_SIZE = 100;
  
  public ArrayList() {
    this.list = new Object[DEFAULT_SIZE];
  }
  
  public ArrayList(int capacity) {
    if (capacity < DEFAULT_SIZE) {
      this.list = new Object[DEFAULT_SIZE];
    } else {
      this.list = new Object[capacity];
    }
  }
  
  public void add(E e) {
    if (this.size == this.list.length) {
      int oldValue = this.list.length;
      int newValue = oldValue + (oldValue >> 1);
      this.list = Arrays.copyOf(this.list, newValue);
    }
    this.list[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
     return null; 
    }
    return (E) this.list[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, Object e) {
    if (index < 0 || index >= this.size) {
      return null; 
     }
    E oldValue = (E) this.list[index];
    this.list[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null; 
     }
    E oldValue = (E) this.list[index];
    System.arraycopy(this.list, index + 1, this.list, index, this.size - (index + 1));
    this.size--;
    this.list[size] = null;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
    }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    return arr;
  }
  
  public void add(int index, E e) {
    if (index < 0 || index >= this.size) {
      return; 
     }
    if (this.size == this.list.length) {
      int oldValue = this.list.length;
      int newValue = oldValue + (oldValue >> 1);
      this.list = Arrays.copyOf(this.list, newValue);
    }
    System.arraycopy(this.list, index, this.list, index + 1, this.size);
    this.list[index] = e;
  }

}
