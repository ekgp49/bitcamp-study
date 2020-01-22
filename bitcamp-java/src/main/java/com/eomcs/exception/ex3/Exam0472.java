// 던지는 예외 받기 - Throwable 변수로 예외를 받지 말라
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0472 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
    else if (i < 0)
      throw new Error(); // 시스템 오륙 ㅏ발생한다고 가정하자
  }

  public static void main(String[] args) {
    try {
      // try 블록에서 예외가 발생할 수 있는 메서드를 호출한다.
      m(-1);

    } catch (Exception e) {
      System.out.println("애플리케이션 예외 발생!");
      // Exception 계열의 애플리케이션 에러만 처리하라.
      // 이렇게 하면 시스템 예외는 main() 호출자에게 위임하게 된다.
    }

  }

}
