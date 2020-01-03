// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0112 {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Bike b = new Bike();
        Car c = new Car();
        Sedan s = new Sedan();
        Truck t = new Truck();
        
        // 레퍼런스는 같은 타입의 객체를 가리킬 수 있을 뿐만아니라 
        // 그 클래스의 서브클래스 객체까지 가리킬 수 있다.
        // 왜? 서브 클래스는 항상 상위 클래스의 모든 것을 사용할 수 있기 때문이다.
        //
        // 이런 규칙에 따라, 다음 v2 변수는 Vehicle 객체 뿐만아니라 
        // Bike, Car, Sedan, Truck 객체까지 다양한 서브클래스의 객체를 가리킬 수 있다.
        // 그래서 v2를 "다형적 변수"의 기능을 갖고 있다 말한다. 
        Vehicle v2 = null;
        v2 = b; // OK
        v2.model = "티코";
        v2.capacity = 5;
//        v2.engine = "1"; // 컴파일 오류
        
        v2 = c; // OK
        v2 = s; // OK
        v2 = t; // OK
        
        Bike b2 = null;
        // 하위 클래스의 레퍼런스로 상위 클래스의 인스턴스를 가리킬 수 없다.
        // => 상위 클래스의 인스턴스에는 하위 클래스의 인스턴스 변수가 없을 수 있기 때문이다.
        //b2 = v; // 컴파일 오류!
       
        // 만약 위의 코드가 가능하다면
        // 다음과 같이 Bike 레퍼런스로 Bike 인스턴스 변수를 사용하려 할 것이다.
        //b2.engine = true;
        
        // 그러나 b2가 실제 가리키는 것은 Bike의 인스턴스 변수가 없는 Vehicle인스턴스를 가리키기 때문에
        // 다음과 같이 Bike의 engine 변수를 사용할 수 없다.
        // 이렇게 개발자가 레퍼런스를 통해 존재하지 않눈 인스턴스 멤버를 사용할까봐
        // 이것을 미리 방지하려고 아예 컴파일 단계에서 이런 사용을 막는 것이다.
        
    }

}
