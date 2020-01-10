// 제네릭(Generic) - 사용 후: 다형적 변수의 한계 극복
package com.eomcs.generic.ex01;

public class Exam0113 {

  // Box 클래스에서 다룰 객체의 타입을 파라미터로 받는다.
  static class Box<T> {

    // T변수는 Box 클래스가 다루는 객체 타입을 가리킨다.
    // 그래서 T 변수를 타입파라미터라고 부른다.
    // 타입 파라미터도 변수이기 때문에 이름은 맘대로 지어도 된다.
    // 자바에서 제안하는 변수 이름:
    // T(Type), E(Element), K(Key), V(Value), N(Number)
    // 여러개 파라미터 선언해야 할 때 두번째 파라미터부터 :
    // S(두번째 파라미터 이름), U, V 등
    T value;

    public void set(T value) {
      this.value = value;
    }

    public T get() {
      return this.value;
    }
  }

  public static void main(String[] args) {
  
    Box<Member> box1 = new Box<Member>/*인스턴스에는 <> 이렇게 생략 가능*/();
    // 인스턴스에 <>를 빼면 경고가 뜨며 내부적으론 Object를 타입으로 지정한 것으로 다룬다.
    
    box1.set(new Member("옹", 10)); // Member가 아닌 다른 객체를 넣으면 컴파일 오류

    Member m = box1.get();  // 따로 형변환 할 필요가 없다
    System.out.println(m);
    
    // 제네릭의 특징 : 지정한 타입 전용 클래스로 동작한다.
    //            그래서 타입이 아닌 경우 메서드를 호출할 수 없다.
//    box1.set(new String("옹")); // error
    
    // 결론 : 제네릭 문법을 사용하면 Object 타입을 사용하는 것보다 편리하다
    // 각 타입별로 클래스를 따로 정의한듯한 효과가 있다.
  }
}








