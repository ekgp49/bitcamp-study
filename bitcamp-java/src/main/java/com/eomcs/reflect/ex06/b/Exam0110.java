package com.eomcs.reflect.ex06.b;

import java.lang.reflect.Proxy;

// 호출되는 메서드(인터페이스에 규칙으로 정의된 메서드들)를 알아내는 방법
public class Exam0110 {
  public static void main(String[] args) {

    MyInterface obj = (MyInterface) Proxy.newProxyInstance(//
        Exam0110.class.getClassLoader(), // 클래스를 메모리에 로딩하는 일을 하게 될 객체
        new Class[] {MyInterface.class}, // 자동생성할 클래스가 구현해야 하는 인터페이스 목록
        new MyInvocationHandler());

    obj.m1();
    obj.m2();
  }
}
