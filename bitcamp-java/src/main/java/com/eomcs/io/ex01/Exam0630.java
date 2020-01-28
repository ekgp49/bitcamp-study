// 익명 클래스로 파일 필터 만들기
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0630 {


  public static void main(String[] args) throws Exception {
    // 필터 객체를 한번만 만들거라면 인멱클래스로 만드는게 낫다


    File dir = new File(".");

    // => 확장자가 .java 인 파일의 이름만 추출하기
    // 1) 필터 준비

    // 2) 필터를 사용하여 디렉토리의 목록을 가져오기
    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if (file.isFile() && file.getName().endsWith(".java"))
          return true; // 조회 결과에 포함시켜라!
        return false; // 조회 결과에서 제외하라!
      }
    });

    for (File file : files) {
      System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-", file.length(),
          file.getName());
    }

  }

}


