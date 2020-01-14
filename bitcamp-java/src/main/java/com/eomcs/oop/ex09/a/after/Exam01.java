// Worker 구현체 사용
package com.eomcs.oop.ex09.a.after;

// 작업:
// 1) worker 객체의 사용 규칙을 정의한다.
//  => Worker 인터페이스 정의
// 2) 클래스를 정의할 때 Worker 규칙에 따라 만든다.
//  => BlueWorker, WhiteWorker, JubuWorker 클래스 변경
// 
public class Exam01 {
  public static void main(String[] args) {
    // 같은 사용 규칙에 따라 만든 클래스는 
    // 한 인터페이스 레퍼런스에 그 객체 주소를 저장 할 수 있어 편리하다.
    // 인터페이스 레퍼런스
    // => 인터페이스를 구현한 클래스의 객체 주소를 저장하는 변수
    Worker w1 = new BlueWorker();

    // 인터페이스를 구현하지 않은 클래스의 인스턴스 주소를 저장할 수 없다. 
    //Worker w2 = new String();// 컴파일 오류!

    Worker w2 = new WhiteWorker();
    Worker w3 = new JubuWorker();
    
    
    // 사용하려는 객체가 같은 인터페이스를 구현하였다면
    // 다음과 같이 동일한 사용규칙에 따라 메서드를 호출할 수 있어 편리하다.
    // 호출에 일관성이 있어 유지보수에 좋다.
    w1.execute();
    w2.execute();
    w3.execute();

    // 역할?
    // caller : Exam01
    // callee : BlueWorker, WhiteWorker, JubuWorker
    // 사용 규칙: Worker
    
    // 참고!
    Worker w;
    // 인터페이스 레퍼런스?
    // => 해당 인터페이스에 따라 작성된(사용 규칙을 준수하는) 클래스의 인스턴스 주소를
    //    저장한다. 줄여서 걍 Worker 객체를 저장하는 변수라고 함

  }
}



