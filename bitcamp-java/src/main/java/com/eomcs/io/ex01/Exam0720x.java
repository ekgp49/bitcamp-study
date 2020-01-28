// 지정한 폴더를 삭제하라
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720x {

  public static void main(String[] args) throws Exception {
    File dir = new File("temp");

    deleteFile(dir);
  }

  // 이게 더 간결함
  static void deleteFile(File dir) {
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (File file : files) {
        deleteFile(file);
      }
      dir.delete();
    }
  }
}


