package com.eomcs.basic.ex07.test.assignment;

public class Test02_teacher {
  public static void main(String[] args) throws Exception {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    // 오름차순으로 정렬을 수행
    // => 출력 결과 : -3, 0, 4, 12, 22, 34, 45, 78
    sort(values); 
    printValues(values);
  }

  static void sort(int[] values) throws Exception {
    // 배열 개수보다 한번 적게 반복. 마지막 숫자는 반복할게 없으니까
    for (int x = (values.length - 1); x > 0; x--) {
    
      int temp = 0;
    
      for (int i = 0; i < x; i++) {
        Thread.currentThread().sleep(1000);
        printValues(values, i);
       
        if (values[i] > values[i + 1]) {
          temp = values[i];
          values[i] = values[i + 1];
          values[i + 1] = temp;
          
          Thread.currentThread().sleep(1000);
          printValues(values, i);
        }
      }
    }
  }

  static void printValues(int[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.printf("%3d ", values[i]);
    }
    System.out.println();
  }
  
  static void printValues(int[] values, int currPos) {
    for (int i = 0; i < values.length; i++) {
      if (i == currPos) {
        System.out.printf("%3d<- ", values[i]);
      }
      System.out.printf("%3d   ", values[i]);

    }
    System.out.println();
  }

}
