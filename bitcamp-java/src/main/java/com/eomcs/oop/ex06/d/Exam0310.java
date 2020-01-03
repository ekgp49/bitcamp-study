// Object 클래스의 메서드를 오버라이딩 하기 - equals()
package com.eomcs.oop.ex06.d;

public class Exam0310 {

  static class Member /*extends Object */{
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String[] args) {
    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("홍길동", 20);

    System.out.println(m1 == m2);

    // equals()
    // => 두개의 인스턴스가 같은 인스턴스인지 비교한다
    // => ==연산자와 동일하게 동작한다.
    // => 이 메서드는 Object에 정의된 메서드이기 때문에
    // => 자바의 모든 클래스는 이 메서드를 사용할 수 있다.
    System.out.println(m1.equals(m2)); 
    // m1과 m2는 다른 인스턴스 이기 때문에 결과는 당연히 false이다.
    // equals()는 String 클래스에서 문자열 비교에 사용했던 메서드이다.
    // 두 문자열의 인스턴스가 달라도 내용이 같으면 true를 리턴했다.
    // 그런데 위의 실행 결과를 보면 m1과 m2가 비록 인스턴스는 다르지만
    // 내용이 같기 때문에 true를 리턴할 것이라 예상했는데
    // 실제 리턴 값을 확인해보면 false를 리턴한다.
    // 이유?
    // => Object 클래스에서 상속 받아 쓰는 equals()는 원래 내용물을 비교하는 게 아니라
    //    인스턴스가 같은지를 비교하는 메서드이다.
    // => m1, m2 인스턴스가 다르니 당연히 그 결과가 false인 것이다.
    //
    
    System.out.println("-------------------------");
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    System.out.println(s1 == s2);
    
    System.out.println(s1.equals(s2));
    // s1 s2가 서로 다른 인스턴스임에도 불구하고 true를 리턴한다.
    // 이유
    // => String 클래스에서 Object의 toString을 오버라이딩 했기 때문이다.
    // => 인스턴스가 다르더라도 문자열이 같으면 true를 리턴하도록 toString() 메서드를 재정의하였다
    // 그래서 String에 대해 equals()를 호출하면 Member와 달리 true를 리턴한다.
    // Member 객체에 대해서도 인스턴스가 다르더라도 데이터가 같으면 true를 리턴하도록 하고 싶으면 toString()을 오버라이딩하라.
    
    // Member의 내용이 같은지 비교하고 싶은가?
    // => 이럴 때 "오버라이딩"을 사용하는 것이다.
    // => 즉 Object로부터 상속 받은 메서드가 Member 클래스에 맞지 않다.
    //    그럼 Member 클래스에 맞게끔 재정의하면 되는 것이다.
    // 다음 Exam0320.java를 보라!

  }
}








