// Wrapper 클래스 - wrapper 객체 생성
package com.eomcs.corelib.ex02;

public class Exam0230 {
  public static void main(String[] args) {

    Integer obj1 = new Integer(100); // Heap에 인스턴스 생성
    Integer obj2 = new Integer(100); // Heap에 인스턴스 생성
    System.out.println(obj1 == obj2); // false
    // 설명:
    // => new 연산자를 통해 Integer 객체를 생성하면 Heap에 인스턴스를 생성한다.
    // => 그래서 같은 값이더라도 다른 인스턴스가 생성된다.


    Integer obj3 = 100; // Integer.valueOf(100)
    Integer obj4 = 100; // Integer.valueOf(100)
    System.out.println(obj3 == obj4); // true
    // 설명:
    // => 정수 값이 -128 ~ 127 범위의 수일경우 auto-boxing으로 객체를 생성할 경우
    // => 내부 보관소(cache)에 저장된다.
    // => 메모리를 효율적으로 사용하기 위해
    // 같은 값을 가지는 Integer 객체가 여러 개 존재해야 할 필요가 없다.
    // => 그래서 가능한 이 방법을 사용해야 한다.
    // => 자바에서도 메모리 절약을 위해 이 방법을 사용하도록 유도하기 위해
    // Wrapper 클래스의 생성자를 Deprecated로 선언하였다.


    Integer obj5 = Integer.valueOf(100);
    Integer obj6 = Integer.valueOf(100);
    System.out.println(obj5 == obj6); // true
    // auto-boxing은 Wrapper 클래스의 valueOf()를 호출하는 코드로 처리된다.
    //

    // 다음과 같이 auto-boxing으로 생성된 객체와 valueOf()가 리턴한 객체를 비교해 보자!
    System.out.println(obj3 == obj5); // true

    // 주의!
    // -128 ~ 127 범위를 넘어가는 경우
    // 무조건 새 인스턴스를 만들고 캐시에 보관하지 않는다.
    Integer i7 = 128;
    Integer i8 = 128;
    Integer i9 = 128;
    System.out.println(i7 == i8);
    System.out.println(i7 == i9);
    System.out.println(i9 == i8);
  }
}


