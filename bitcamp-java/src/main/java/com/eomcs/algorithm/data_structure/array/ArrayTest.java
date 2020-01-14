package com.eomcs.algorithm.data_structure.array;

public class ArrayTest {

  public static void main(String[] args) {
    ArrayList2<String> arr = new ArrayList2<>();
  
    arr.add("aaa");
    arr.add("bbb");
    arr.add("ccc");
    arr.add("ddd");
    arr.add("eee");
    print(arr);
    
    System.out.println(arr.get(0));
    System.out.println(arr.get(1));
    
    arr.add(1, "xxx");
    arr.add(3, "xxx");
    arr.add(5, "xxx");
    print(arr);
    System.out.println("------------");
    System.out.println(arr.set(1, "ooo"));
    arr.set(3, "ooo");
    arr.set(5, "ooo");
    print(arr);
    
    arr.remove(1);
    arr.remove(2);
    arr.remove(3);
    arr.remove(1);
    arr.remove(1);
    arr.remove(1);
    arr.remove(1);
    arr.remove(1);
    arr.remove(1);
    arr.remove(0);
    print(arr);
  }
  
  
  static void print(ArrayList2<String> arr) {
    String[] list = new String[arr.size()];
    arr.toArray(list);
    for (String i : list) {
      System.out.println(i);
    }
    System.out.println(arr.size);
  }
  
}
