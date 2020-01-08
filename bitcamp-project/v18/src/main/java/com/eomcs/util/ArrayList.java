package com.eomcs.util;
import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFAULT_CAPACITY = 3;
  Object[] list;
  int size;  

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    
//    for (int i = 0; i < arr.length; i++) {
//      arr[i] = (E) this.list[i];
//    }
//    return arr;
    
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
    }
    System.arraycopy(this.list, 0, arr, 0, this.size); // arraycopy는 위의 코드와 같다
    return arr; 
    
    // arrayType의 타입으로 size만큼의 배열을 만드는 copyOf 메소드
    // 그 다음 list배열에 저장된 주소를 새로 만든 배열에 복사한다.
    // return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
  }

  public void add(E obj) {
    if (this.list.length == this.size) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d개 생성하였음\n", newCapacity); 
    }
    this.list[this.size++] = obj;
  }

  @SuppressWarnings("unchecked")
  public E get(int idx) {
    if (idx >= 0 && idx < this.size) {
      return (E) this.list[idx];
    } else {
      return null;
    }
  }
  
  public int size() {
    return this.size;
  }
}
