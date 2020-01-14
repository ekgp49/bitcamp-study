package com.eomcs.util;

public class Queue<E> extends LinkedList<Object> implements Cloneable {
  public void offer(Object value) {
    this.add(value);
  }
  
  @SuppressWarnings("unchecked")
  public E poll() {
    return (E) this.remove(0); // 꺼내면서 지워야해서 get() 대신 remove() 씀
  }
  
  /*
  @Override
  public Queue clone() {
    try {
      // Object의 clone()은 shallow copy를 수행함
      // queue에서 poll()을 수행하면 first 노드를 삭제하게 되고 이때 원본 객체의 노드의 링크 정보를 변경하게 된다.
      // => 따라서 다음에 다시 복제를 수행하면 원본 노드의 링크 정보가 제거되었기 때문에 제대로 작업을 수행할 수 없다.
      // 해결책
      // => 원본 객체가 사용하는 노드도 함께 복제해야 한다.
      // 즉 deep copy를 수행해야 한다.
      return (Queue) super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */
  
  public Queue<E> clone() {
    // deep copy 수행
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
}
