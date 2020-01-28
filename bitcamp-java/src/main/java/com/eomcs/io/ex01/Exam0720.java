// 지정한 폴더를 삭제하라
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720 {

  public static void main(String[] args) throws Exception {
    File dir = new File("temp");
    deleteFile(dir);
  }

  static void deleteFile(File dir) {
    if (!dir.exists()) {
      System.out.println("해당 파일이 없습니다.");
      return;
    }
    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        deleteFile(file);
      } else {
        file.delete();
      }
    }
    dir.delete();
    System.out.println("삭제하였습니다.");
  }
}


