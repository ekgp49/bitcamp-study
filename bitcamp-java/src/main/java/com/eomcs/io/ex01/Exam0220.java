// 파일 정보 조회 - java.io.File 클래스
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0220 {

  public static void main(String[] args) throws Exception {
    // File 클래스
    // => 파일이나 디렉토리 정보를 관리
    // => 파일이나 디렉토리를 생성,삭제,변경

    // 존재하지 않는 파일 정보 조회
    File file2 = new File("./build.gradle2");
    System.out.printf("폴더명: %s\n", file2.getName());
    System.out.printf("파일크기: %d\n", file2.length());
    System.out.printf("경로: %s\n", file2.getPath());
    System.out.printf("절대경로: %s\n", file2.getAbsolutePath());
    System.out.printf("계산된 절대경로: %s\n", file2.getCanonicalPath());
    System.out.printf("총크기: %d\n", file2.getTotalSpace());
    System.out.printf("남은크기: %d\n", file2.getFreeSpace());
    System.out.printf("가용크기: %d\n", file2.getUsableSpace());
    System.out.printf("디렉토리여부: %b\n", file2.isDirectory());
    System.out.printf("파일여부: %b\n", file2.isFile());
    System.out.printf("감춤여부: %b\n", file2.isHidden());
    System.out.printf("존재여부: %b\n", file2.exists());
    System.out.printf("실행가능여부: %b\n", file2.canExecute());
  }

}


