package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> extends List<E> {
  Object[] elementData;
  private static final int DEFAULT_SIZE = 100;
  
  public ArrayList() {
    this.elementData = new Object[DEFAULT_SIZE];
  }
  
  public ArrayList(int capacity) {
    if (capacity < DEFAULT_SIZE) {
      this.elementData = new Object[DEFAULT_SIZE];
    } else {
      this.elementData = new Object[capacity];
    }
  }
  
  @Override
  public void add(E e) {
    if (this.size == this.elementData.length) {
      int oldValue = this.elementData.length;
      int newValue = oldValue + (oldValue >> 1);
      this.elementData = Arrays.copyOf(this.elementData, newValue);
    }
    this.elementData[this.size++] = e;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
     return null; 
    }
    return (E) this.elementData[index];
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null; 
     }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null; 
     }
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, this.elementData, index, this.size - (index + 1));
    this.size--;
    this.elementData[size] = null;
    return oldValue;
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public Object[] toArray() {
    return (E[]) Arrays.copyOf(this.elementData, this.size);
  }
  
  @Override
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr;
  }
  
  @Override
  public void add(int index, E e) {
    if (index < 0 || index >= this.size) {
      return; 
     }
    if (this.size == this.elementData.length) {
      int oldValue = this.elementData.length;
      int newValue = oldValue + (oldValue >> 1);
      this.elementData = Arrays.copyOf(this.elementData, newValue);
    }
    System.arraycopy(this.elementData, index, this.elementData, index + 1, this.size - index);
    this.elementData[index] = e;
  }

}
