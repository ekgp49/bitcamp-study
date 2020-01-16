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
    
    // 로컬 클래스 : 특정 메서드 안에서만 사용되는 클래스라면 그 메서드 안에 로컬 클래스로 정의하라
    
    class StackIterator<T> implements Iterator<T> {
      Stack<T> stack;
      
      @SuppressWarnings("unchecked")
      public StackIterator() {
        this.stack = (Stack<T>)Stack.this.clone();
      }
      
      public T next() {
        return stack.pop();
      }
      
      public boolean hasNext() {
        return !stack.empty();
      }
    }
    // 로컬 클래스의 인스턴스를 생성할 때 바깥 클래스의 인스턴스 주소를 줘서는 안된다.
    // 즉 생성자를 호출하는 앞쪽에 this.를 붙여서는 안된다.
    return new StackIterator<>();
  }
  
  /*
  static void m1() {
    // static 메서드는 클래스 이름으로 바로 호출 할 수 있기 때문에 
    // this 변수가 없다.
    // 예 ) Stack.m1();
    class A {
      A() {
        Stack s;
//        s = Stack.this; // 컴파일 오류!
        // 이 로컬 클래스는 m1()에서 사용할 것이다.
        // m1()은 바깥 클래스의 인스턴스 주소를 모른다
        // 그런데 로컬 클래스에서 위와 같이 바깥 클래스의 인스턴스를 사용하려 한다면
        // 문제가 되는 것이다 => 컴파일 오류 발생
        
      }
    }
  }
   */ 
}
