// 클래스의 종류 : 패키지 멤버 클래스 사용
package com.eomcs.oop.ex11.b;

import java.io.File;

// 물론 Exam0110 또한 패키지 멤버 클래스이다.
public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // 현재 폴더에 들어있는 하위 폴더 및 파일들의 이름을 출력하라
    // 현재 폴더?
    //  => 이클립스에서 소스를 실행할 경우 현재 폴더는 프로젝트 폴더이다.
    
    // => File 클래스를 이용하여 현재 폴더의 정보를 알아낸다
    //    File 클래스는 OS의 기능을 이용하여 폴더 및 파일 정보를 다루는 일을 한다.
    File dir = new File(".");

    // 패키지 멤버 클래스의 인스턴스를 생성한다.
    JavaFilter javaFilter = new JavaFilter();

    // 패키지 멤버 클래스의 인스턴스를 필터로 사용하여 디렉토리 안의 목록을 추출한다.
    String[] names = dir.list(javaFilter);
    for (String name : names) {
      System.out.println(name);
    }

  }

}







