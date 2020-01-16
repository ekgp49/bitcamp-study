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
  
  public Iterator<E> iterator() {
    // anonymous class : 인스턴스를 한개만 생성한다면 로컬 클래스를 익명 클래스로 정의하라
    // 익명 클래스를 리턴하는게 아니라 익명클래스의 객체를 만들어 그 객체주소를 리턴하는 것이다.
    return new Iterator<E>() {
      Stack<E> stack;
      
      {
        this.stack = Stack.this.clone();
      }
      
      public E next() {
        return stack.pop();
      }
      
      public boolean hasNext() {
        return !stack.empty();
      }
    };
  }
}
