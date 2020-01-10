// Wrapper 클래스 - wrapper 객체의 값 비교 
package com.eomcs.corelib.ex01;

public class Exam0231 {
  public static void main(String[] args) {
    Integer obj1 = Integer.valueOf(100); 
    Integer obj2 = Integer.valueOf(100);
    System.out.println(obj1 == obj2); // true
    // constants pool에 wrapper 객체 오직 하나 생성됨. 그래서 equals()나 == 둘 다로 비교 가능

    Integer obj3 = new Integer(100);
    Integer obj4 = new Integer(100);
    System.out.println(obj3 == obj4); //false
    // ==연산자는 못씀

    System.out.println(obj3.equals(obj4)); // true
    // 그러나 다음과 같이 new 연산자로 만든 wrapper객체는 값이 같더라도 
    // 인스턴스가 따로 생성되므로 Integer 클래스가 오버라이딩한 equals()메서드로 비교해야한다.
    
    // 결론 :
    // => Wrapper 객체를 생성할 때는 new 연산자를 사용하지 말고 valueOf()나 auto-boxing 기능을 이용하라.
    // => 그러면 값을 비교할 때 == 나 equals() 메서드를 이용할 수 있다.
    
    // 참고 : Wrapper 클래스는 모두 String 클래스처럼 
    // 상속받은 Object의 equals()를 오버라이딩하였다.
    // 즉 인스턴스를 비교하는게 아니라 값이 같은지를 비교한다.
    
  }
}






