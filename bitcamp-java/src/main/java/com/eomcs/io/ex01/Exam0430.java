// 특정 폴더를 생성하여 그 폴더에 파일을 만든다.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0430 {

  public static void main(String[] args) throws Exception {
    // 생성할 파일의 경로 설정
    File file = new File("temp/b/test.txt");


    // b 디렉토리가 없기 때문에 예외발생
    if (file.createNewFile()) { // 파일 생성
      System.out.println("test.txt 파일을 생성하였습니다.");
    } else {
      System.out.println("test.txt 파일을 생성할 수 없습니다.");
    }


  }

}
