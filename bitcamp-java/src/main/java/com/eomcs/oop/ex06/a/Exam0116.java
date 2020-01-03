// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0116 {

    public static void main(String[] args) {
      // 상위 클래스의 레퍼런스로 하위 클래스의 인스턴스를 가리킬 때
        Car c = new Car();
        
        c.capacity = 5; // vehicle의 인스턴스 변수
        c.model = "티코"; // vehicle의 인스턴스 변수
        c.valve = 16; // car의 인스턴스 변수
        // 형변환(type casting)으로 컴파일러를 속일 수 있지만
        // 실행할 때 오류를 발생시킬것이다(runtime exception)
        // 실행하지 말라
        Sedan s = (Sedan)c;
        s.sunroof = true;
        s.auto = true;
    }

}
