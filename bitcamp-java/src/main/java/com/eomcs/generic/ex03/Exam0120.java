package com.eomcs.generic.ex03;

import java.lang.reflect.Array;

public class Exam0120 {

  // 제네릭의 타입을 지정할 때 수퍼 클래스를 지정하면 그 타입 및 서브 타입만 가능하다.
  // 다음 클래스는 타입 파라미터는 Manager나 그 하위 클래스만 지정할 수 있다.
  static class ArrayList<T extends Manager> {
    T[] arr;
    int index = 0;

    @SuppressWarnings("unchecked")
    public ArrayList(Class<?> clazz) {
      this.arr = (T[])Array.newInstance(clazz, 10);
    }

    public void add(T v) {
      arr[index++] = v;
    }

    public T get(int index) {
      return arr[index];
    }
  }

  public static void main(String[] args) {

    ArrayList<Manager> obj = new ArrayList<>(Manager.class);
    ArrayList<Administrator> obj1 = new ArrayList<>(Administrator.class);
//    obj.add(new Member());
//    obj.add(new Student());
//    obj.add(new Teacher()); 얘네는 매니저 계열이 아니라서 못들어감
    obj.add(new Manager());
    obj.add(new Administrator());

    System.out.println(obj.get(0));
    System.out.println(obj.get(1));
    System.out.println(obj.get(2));
    System.out.println(obj.get(3));
  }

}
