package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E> {
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
