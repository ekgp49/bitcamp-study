// 지정한 폴더 및 그 하위폴더까지 모두 검색하여 파일 및 디렉토리 이름 출력
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710 {

  public static void main(String[] args) throws Exception {
    File dir = new File(".");

    System.out.println(dir.getCanonicalPath());
    printList(dir, 1);
  }

  static void printList(File dir, int level) {
    File[] files = dir.listFiles();
    for (File file : files) {
      printLevelIndent(level);
      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      } else {
        System.out.print("\\- ");
        System.out.printf("%s\n", file.getName());
      }
    }
  }

  static void printLevelIndent(int level) {
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
    }
  }

}


