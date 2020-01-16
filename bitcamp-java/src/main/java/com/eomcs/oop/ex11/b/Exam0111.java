// 클래스의 종류 : 패키지 멤버 클래스 사용
package com.eomcs.oop.ex11.b;

import java.io.File;

// 물론 Exam0110 또한 패키지 멤버 클래스이다.
public class Exam0111 {

  public static void main(String[] args) throws Exception {
    File dir = new File(".");
    
    // 이름이 .java로 긑나는 파일만 꺼낸다
    //  => JavaFilter 클래스는 com.eomcs.oop.ex11.a 패키지에 소속된 멤버 클래스이다.
    //  => Filter 구현체이다.
    //  => File.list()를 호출할 때 파라미터로 넘겨준다.
    //  => 그러면 list()메서드가 리턴할 이름을 준비할 때 FilenameFilter의 결정에 따라
    //     리턴 목록에 포함시킬지 말지 결정한다.
    JavaFilter javaFilter = new JavaFilter();
    
    String[] names = dir.list(javaFilter);
    for (String name : names) {
      System.out.println(name);
    }

  }

}







