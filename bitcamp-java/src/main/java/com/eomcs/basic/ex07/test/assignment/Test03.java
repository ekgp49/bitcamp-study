package com.eomcs.basic.ex07.test.assignment;

public class Test03 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
   
    // 배열에 들어 있는 값을 거꾸로 변경하라.
    // => 출력결과 : -22, 0 45, 22, 12, 78, -3, 4, 34
    reverse(values); 
    for (int value : values) {
      System.out.println(value);
    }
  }
  
  static int[] reverse(int[] value) {
    for(int i = 0; i < value.length/2; i++) {
      int temp;
      temp = value[i];
      value[i] = value[value.length-1-i];
      value[value.length-1-i] = temp;
    }
    
    
    return value;
  }
  
  
}
