package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {
  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return (E) this.remove(0); // 꺼내면서 지워야해서 get() 대신 remove() 씀
  }
 
  public Queue<E> clone() {
    // deep copy 수행
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
  
  public Iterator<E> iterator() {
   
    
    // local class : 특정 메서드 안에서만 사용되는 중첩 클래스라면 로컬클래스로 정의하라
    // 로컬 클래스는 인스턴스 멤버가 아니다. 따라서 로컬 클래스의 생성자를 호출할 때
    // 앞에 this.를 붙이면 안된다.
    class QueueIterator<T> implements Iterator<T> {
      Queue<T> queue;
      
      @SuppressWarnings("unchecked")
      public QueueIterator() {
        this.queue = (Queue<T>) Queue.this.clone();
      }
      
      public T next() {
        return queue.poll();
      }
      
      public boolean hasNext() {
        return queue.size() > 0;
      }
    }

    return new QueueIterator<>();
  }
  
}
