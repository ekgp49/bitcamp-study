package com.eomcs.util;

public class StackIterator<E> implements Iterator<E> {
  Stack<E> stack;
  
  public StackIterator(Stack<E> stack) {
    this.stack = stack.clone();
  }
  
  public E next() {
    return stack.pop();
  }
  
  public boolean hasNext() {
    return !stack.empty();
  }
}
