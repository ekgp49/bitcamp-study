// 제네릭(Generic) - 사용 전: 다형적 변수의 문제점
package com.eomcs.generic.ex01;

public class Exam0112 {

  static class ObjectBox {
    Object value;
    
    public void set(Object value) {
      this.value = value;
    }
    
    public Object get() {
      return this.value;
    }
  }
  
  public static void main(String[] args) {
    ObjectBox box1 = new ObjectBox();
    
    box1.set(new String("Hello")); // Member가 아닌 String 객체를 넣었는데도 컴파일 오류가 나지 않는다.
    // 이유? => set()의 파라미터 타입은 Object이기 때문이다.
    
    Member m = (Member) box1.get(); 
    System.out.println(m);
    
    // Object 레퍼런스의 치명적 단점:
    // => 의도와 다른타입의 값을 저장하는 것을 막을 수 없다.
    
    // 이렇게 Box 클래스의 인스턴스 변수를 Object로 선언하면 다양한 객체를 보관할 수는 있지만
    // 특정 타입의 객체로 제한할 수 없다.
    // 그렇다고 이전처럼 각 타입 별로 Box 클래스를 정의하는 것은 바람직하지 않다
    
    // 해결법 : 제네릭 문법
  }
}








