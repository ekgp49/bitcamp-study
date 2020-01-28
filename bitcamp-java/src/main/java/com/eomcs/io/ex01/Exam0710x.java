// 지정한 폴더 및 그 하위폴더까지 모두 검색하여 파일 및 디렉토리 이름 출력
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710x {

  public static void main(String[] args) throws Exception {
    File dir = new File(".");
    print(dir, 1);
  }

  static void print(File dir, int count) {
    File[] files = dir.listFiles();
    for (File file : files) {
      for (int i = 0; i < count; i++) {
        System.out.print("  ");
      }
      if (file.isDirectory() && !file.isHidden()) {
        System.out.println(file.getName() + "/");
        print(file, count + 1);
      } else {
        System.out.println("\\-" + file.getName());
      }
    }
  }
}


