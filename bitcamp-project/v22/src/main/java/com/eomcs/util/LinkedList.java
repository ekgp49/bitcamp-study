package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  Node<E> first;

  Node<E> last;

  private int size;

  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;

    if (first == null) {
      first = last = newNode;
    } else {
      //      Node cursor = first;
      //      for (int i = 0; i < this.size - 1; i++) {
      //        cursor = cursor.next;
      //      }
      //      cursor.next = newNode;
      //      last = newNode;
      last.next = newNode;
      last = newNode;
    }
    this.size++;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= size) {
      return;
    }

    Node<E> newNode = new Node<>();
    newNode.value = value;

    Node<E> cursor = first;

    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      for (int i = 0; i < index - 1; i++) {
        cursor = cursor.next;
      }
      newNode.next = cursor.next;
      cursor.next = newNode;
    }
    this.size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Node<E> cursor = first;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return (E) cursor.value;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> cursor = first;

    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }
    Node<E> deletedNode;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
      deletedNode = cursor.next;
      cursor.next = deletedNode.next;
    }
    deletedNode.next = null;

    this.size--;
    return (E) deletedNode.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      return null;
    }

    Node<E> cursor = first;

    E oldValue;
    if (index != 0) {
      for (int i = 0; i < index - 1; i++) {
        cursor = cursor.next;
      }
    }
    oldValue = (E) cursor.value;
    cursor.value = value;

    return oldValue;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.size];
    Node<E> cursor = first;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor;
      cursor = cursor.next;
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), this.size);
    
    Node<E> cursor = first;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return (E[]) arr;
  }

  public int size() {
    return this.size;
  }

  static class Node<T> {
    Node<T> next;
    T value;
  }
}
