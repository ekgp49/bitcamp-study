package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {

  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void push(E value) {
    if (this.size == this.elementData.length) {
      grow();
    }
    this.elementData[this.size++] = value;
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    if (this.empty()) {
      return null;
    }
    E value = (E) this.elementData[--this.size];
    this.elementData[this.size] = null; 
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }

  // Object clone()의 shallow copy
  // => 문제점 : 데이터가 실제 저장된 배열은 복제하지 않는다
  // => 그래서 배열의 값을 바꾸면 원본 스택에도 영향을 미친다.
  /*
  @Override
  public Stack<E> clone() {
    // => Object의 clone()을 재정의할 경우 반드시 Cloneable 인터페이스를 지정해야 한다.
    // 즉 해당 객체가 복사 가능함을 표시하는 문법이다.
    try {
      return (Stack<E>) super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
   */

  // Deep copy를 이용하여 객체 복제하기
  // 데이터가 들어있는 배열도 그대로 복제한다.
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
      Stack<E> temp = (Stack<E>) super.clone();

      // 배열만 복제하고 배열에 저장된 객체까지는 복제하지 않는다.
      Object[] arr = new Object[this.size];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.elementData[i];
      }
    temp.elementData = arr;
    return temp;
    
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }

  private void grow() {
    this.elementData = Arrays.copyOf(this.elementData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = this.elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

}
