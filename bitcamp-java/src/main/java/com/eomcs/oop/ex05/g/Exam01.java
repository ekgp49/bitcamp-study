// 상속 - 수퍼 클래스에 기본 생성자가 없을 때!
package com.eomcs.oop.ex05.g;

public class Exam01 {
    public static void main(String[] args) {
        B obj = new B();
        obj.v2 = 100;
        obj.v1 = 1;
        System.out.printf("v1=%d, v2=%d\n", obj.v1, obj.v2);
    }
}








