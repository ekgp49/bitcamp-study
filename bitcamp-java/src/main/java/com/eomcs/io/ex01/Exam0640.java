// 익명 클래스로 파일 필터 만들기
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0640 {


  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    // => 확장자가 .java 인 파일의 이름만 추출하기

    // 필터 객체를 한번만 만들거라면 익명클래스로 만드는게 낫다.
    // 코드를 더 읽기 쉽게 만든다.
    File[] files =
        dir.listFiles(file -> file.isFile() && file.getName().endsWith(".java") ? true : false);

    for (File file : files) {
      System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-", file.length(),
          file.getName());
    }

  }

}


