// 제네릭(Generic) - 사용 전: 다형적 변수의 활용
package com.eomcs.generic.ex01;

public class Exam0111 {

  // 다양한 객체를 저장하는 Box를 만들기 위해
  // 인스턴스 변수타입을 Object로 선언한다.
  // 그러면 다음과 같이 Box 한개만 정의하면 된다
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
    box1.set(new Member("옹", 22));
    Member m = (Member) box1.get(); // 값 꺼낼 때 형변환을 해야한다
    System.out.println(m);
    
    ObjectBox box2 = new ObjectBox();
    box2.set(new String("Hello"));
    String s = (String) box2.get(); // 값 꺼낼 때 형변환을 해야한다
    System.out.println(s);
    
    ObjectBox box3 = new ObjectBox();
    box3.set(100); 
    int i = (int) box3.get(); // 값 꺼낼 때 형변환을 해야한다 
    System.out.println(i);
    
    // 객체의 타입별로 Box 클래스를 구분해서 쓰지 않으니 코딩이 편하다.
    // 단 값을 꺼낼 때 원래의 타입으로 바꾸기 위해 형변환(type casting)해야하는 불편함이 있다.
    
    // Object 레퍼런스의 치명적 단점:
    // => 의도와 다른타입의 값을 저장하는 것을 막을 수 없다.
  }
}








