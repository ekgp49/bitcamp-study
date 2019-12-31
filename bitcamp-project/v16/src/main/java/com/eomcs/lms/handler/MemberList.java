package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;

public class MemberList {
  Member[] members;
  int size;
  static final int DEFAULT_SIZE = 2;
  
  public MemberList() {
    this.members = new Member[DEFAULT_SIZE];
  }
  
  public MemberList(int capacity) {
    if (capacity < DEFAULT_SIZE || capacity > 100000) {
      this.members = new Member[DEFAULT_SIZE];
    } else {
      this.members = new Member[capacity];
    }
  }
  
  public void add(Member member) {
    if (size == this.members.length) {
      int oldCapacity = this.members.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      /*
      Member[] arr = new Member[newCapacity];
      for (int i = 0; i < memberCount; i++) {
        arr[i] = members[i];
      }
      members = arr;
      */
      members = Arrays.copyOf(members, newCapacity);
    }
    this.members[this.size++] = member;
  }
  
  public Member[] toArray() {
   /*
    Member[] member = new Member[memberCount];
    for (int i = 0; i < memberCount; i++) {
      member[i] = this.members[i];
    }
    return member;
    */
    return Arrays.copyOf(this.members, this.size);
  }

}
