// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_3 {
  public static void main(String[] args) {
    // >>>비트 이동 연산자 사용법
    //빈자리 무조건 0으로 채움
    int i = 0b01101001; // 105
    System.out.println(i); 
    System.out.println(i >>> 1); // 00110100|1 => 52
    System.out.println(i >>> 2); // 00011010|0 => 26
    System.out.println(i >>> 3); // 00001101|0 => 13
    System.out.println(i >>> 4); // 00000110|1 => 6

    // 음수를 이동
    i = 0b11111111_11111111_11111111_10101001; // -87
    System.out.println(i); 
    System.out.println(i >>> 1); 
    // 1_11111111_11111111_11111111_1010100|1   => 2147483604

    System.out.println(i >>> 2); 
    // 11_11111111_11111111_11111111_101010|01 => 1073741802

    System.out.println(i >>> 3); 
    // 111_11111111_11111111_11111111_10101|001 => 536870901

    System.out.println(i >>> 4);
    // 1111_11111111_11111111_11111111_1010|1001 => 268435450
  }
}

