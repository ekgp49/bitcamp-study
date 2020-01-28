// 파일 생성
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0411 {

  public static void main(String[] args) throws Exception {
    // 생성할 파일의 경로 설정
    File file = new File("temp2/b/test.txt");

    // 존재하지 않는 폴더에 파일을 생성하려고 하면 예외발생한다
    // 해당 경로에 디렉토리가 없다면 파일을 생성할 수 없다. 런타임 오류!
    if (file.createNewFile()) { // 파일 생성
      System.out.println("test.txt 파일을 생성하였습니다.");
    } else {
      System.out.println("test.txt 파일을 생성할 수 없습니다.");
    }


  }

}
