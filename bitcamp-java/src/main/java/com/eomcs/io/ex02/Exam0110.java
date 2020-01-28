// Byte Stream - 바이트 단위로 출력하기 (binary stream)
package com.eomcs.io.ex02;

import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // 1) 파일로 데이터를 출력하는 객체를 준비한다.
    // - new FileOutputStream("파일경로")
    // - 지정된 경로에 해당 파일을 자동으로 생성한다.
    // - 기존에 같은 이름의 파일이 있으면 기존 파일을 덮어쓴다.
    FileOutputStream out = new FileOutputStream("temp/test1.data");

    // 2) 1바이트를 출력한다.
    // => int 값을 아규먼트로 넘기더라도 맨 마지막 1바이트만 출력한다.
    out.write(0x7a6b5c4d); // 출력하는 값은 0x4d 이다.

    // 3) 출력 도구를 닫는다.
    // 여러 프로그램ㅇ ㅣ공유하는 자원은 OS에서 관리한다.
    // 사용후 OS에 반납해야 다른 프로그램이 해당 자원을 사용할 수 있다
    // 이런 자원을 사용하는 클래스는 할상 자원을 해제시키는, close()라는 메서드가 있다.
    // => 항상 입출력 도구를 사용한 후 닫아야 한다.
    // => 어떤 입출력 도구는 닫지 않으면 버퍼(임시메모리)에 남아있는 데이터가
    // 출력되지 않고 버려진다.
    out.close();

    System.out.println("데이터 출력 완료!");

  }

}
