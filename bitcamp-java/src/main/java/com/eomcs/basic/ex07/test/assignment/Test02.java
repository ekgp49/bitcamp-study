package com.eomcs.basic.ex07.test.assignment;

public class Test02 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    // 오름차순으로 정렬을 수행
    // => 출력 결과 : -3, 0, 4, 12, 22, 34, 45, 78
    sort(values); 

    for (int value : values) {
      System.out.println(value);
    }
  }

  static int[] sort(int[] value) {
    for (int i = 0; i < value.length; i++) {
      int temp;
      for (int j = 0; j < value.length; j++) {
        if (value[i] < value[j]) {
          temp = value[i];
          value[i] = value[j];
          value[j] = temp;
        }
      }
    }
    
    return value;
  }
  
}