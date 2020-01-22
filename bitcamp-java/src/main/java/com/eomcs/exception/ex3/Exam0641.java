// 예외 처리 후 마무리 작업 - try-with-resources 실행 순서
package com.eomcs.exception.ex3;

public class Exam0641 {
  static class B implements AutoCloseable {
    public static void m(int value) throws Exception {
      if (value < 0) {
        throw new Exception();
      }
      System.out.println("m() 호출!");
    }

    @Override
    public void close() throws Exception {
      System.out.println("close() 호출");
    }
  }

  public static void main(String[] args) throws Exception {
    try (B obj2 = new B() /* 마지막 문장에는 세미콜론을 붙이지 않아도 된다. */) {
      System.out.println("try 블록 실행...시작");
      B.m(-1);
      System.out.println("try 블록 실행...종료");
      // 예외가 발생하면 try 블록이 나가기 전에 close()가 호출된다.
    } catch (Exception e) {
      // close()가 호출 된 후 catch 블록이 실행된다.
      System.out.printf("예외 발생: %s", e.getMessage());
    }
    // finally 블록에서 B의 close()를 호출하지 않아도,
    // 자동으로 호출될 것이다. 실행하여 확인하라!
  }


}
