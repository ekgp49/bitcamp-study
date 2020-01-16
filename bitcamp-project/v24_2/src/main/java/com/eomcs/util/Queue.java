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
    return new QueueIterator<>(this);
  }
  
  static class QueueIterator<E> implements Iterator<E> {
    Queue<E> queue;
    
    public QueueIterator(Queue<E> queue) {
      this.queue = queue.clone();
    }
    
    public E next() {
      return queue.poll();
    }
    
    public boolean hasNext() {
      return queue.size() > 0;
    }
  }

  
}
