package com.eomcs.basic.ex07.test.assignment;

public class Test01 {

  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    // 배열의 값 중에서 최대 값을 출력하라.
    // => 출력 결과 : 78
    int value = max(values); // 메서드 호출
    System.out.println(value);
  }
  
  static int max(int[] values) {
    // 파라미터로 배열을(더 정확하겐 배열주소를) 받고, 그 값 중에서 최대 값을 찾아 리턴한다.
    int maxValue = values[0];
    for(int i = 1; i < values.length; i++) {
      if (values[i] > maxValue) {
        maxValue = values[i];
      }
    }
    return maxValue;
  }

}
