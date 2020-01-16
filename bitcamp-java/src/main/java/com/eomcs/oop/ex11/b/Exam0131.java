// 클래스의 종류 : non-static 중첩 클래스(nested class) 사용
package com.eomcs.oop.ex11.b;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0131 {
  
  class JavaFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
      if (name.endsWith(".java")) 
        return true; 
      return false; 
    }
  }


  public void test() {
    File dir = new File(".");
    
    JavaFilter javaFilter = new JavaFilter();
    
    String[] names = dir.list(javaFilter);
    for (String name : names) {
      System.out.println(name);
    }
  }

  public static void main(String[] args) throws Exception {
    Exam0131 obj = new Exam0131();
    obj.test();
 
    // 스태틱 메서드에서는 스태틱이 안붙은 인스턴스 멤버를 사용할 수 없다.
    // static 메서드에서 인스턴스 멤버를 사용하려면 인스턴스를 꼭 생성해야만 한다.
    // 그리고 이 인스턴스를 가지고 인스턴스 필드/메서드/중첩 클래스를 사용할 수 있다
    
    JavaFilter javaFilter;
    javaFilter = obj.new JavaFilter();
  }

}







