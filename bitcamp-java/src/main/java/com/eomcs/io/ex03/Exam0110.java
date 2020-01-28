// character stream - 문자 단위로 출력하기
package com.eomcs.io.ex03;

import java.io.FileWriter;

public class Exam0110 {
  public static void main(String[] args) throws Exception {
    // 1) 문자 단위로 출력할 도구 준비
    FileWriter out = new FileWriter("temp/test2.txt");

    // 2) 문자 출력하기
    // => 자바는 문자 데이터를 다룰 때 UCS2(2바이트) 유니코드를 사용한다.
    // => 그래서 출력할 때 UCS2 2바이트 유니코드값을
    // JVM에 설정된 기본 문자코드표의 값으로 변환하여 출력한다.
    // [콘솔창에서 실행]
    // => JVM을 실행할 때 출력 데이터의 문자 코드표를 지정하지 않으면
    // OS의 기본 문자코드표에 따라 변환한다.
    // 예) Windows OS(MS949), Unix, Linux, macOS(UTF-8)
    // => JVM을 실행할 때 출력 데이터의 문자 코드표를 지정하는 방법
    // > java -Dfile.encoding=문자코드표 -cp 클래스경로 클래스명
    // [이클립스에서 실행]
    // - 출력할 때 UCS2를 UTF-8 코드로 변환하여 출력한다.

    // => 따라서 다음 4바이트 값을 출력하면
    // 앞의 2바이트는 버리고, 뒤의 2바이트(UCS2)를 UTF-8 코드표에 따라
    // 1 ~ 4 바이트 값으로 변환하여 출력한다.
    out.write(0x7a6bac00);
    // 앞의 2바이트 (7a6b)는 버린다.
    // 뒤의 2바이트 (ac00)는 UTF-8 코드값으로 변환되어 출력된다.

    // UCS2에서 A는 0041이다.
    // 출력하면 utf-8 41이 출력된다
    out.write(0x7a5f0041);
    out.close();

    System.out.println("출력 완료!");

  }
}
