// 초기화 블록 - 클래스 블록 = 스태틱 블록
package com.eomcs.oop.ex03;

public class Exam0646 {
    
    public static class A {
        static int a;
        static void m() {}
        
        // 스태틱 블록은 클래스가 로딩된 후에 자동으로 순서대로 실행된다.
        static {
            System.out.println("Static{} 11111");
        }
        
        static {
            System.out.println("Static{} 22222");
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 클래스가 로딩되는 경우
        
        // => 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다.
        A obj1;
//        
//        // 1) 클래스 멤버(변수와 메서드)를 최초로 사용할 때  
//        A.a = 100;
//        System.out.println("-----------");
//        
//        A.m();
//        System.out.println("***********");
//        
//        // 2) 해당 클래스의 인스턴스를 최소로 생성할 때
//        //    => 인스턴스를 만들려면 설계도가 있어야 하고,
//        //       설계도는 메모리에 로딩되어 있어야 한다.
//        //       따라서 설계도가 없으면 즉시 설계도를 로딩할 것이다.
//        new A();
//        
//        System.out.println("=======================");
//        // 3) 자바에서 제공하는 도구를 사용하여 
//        //    => 이미 클래스가 로딩되어 있다면 다시 로딩하지 않는다.
//        //    => 자바는 중복해서 클래스를 메모리에 로딩하지 않는다. 메모리 절약!
//        Class.forName("com.eomcs.oop.ex03.Exam0646$A");
//        
          // 클래스가 로딩 된 후 클래스 필드가 생성되고, 클래스블록(스태틱블록)이 실행된다.
        // 클래스는 중복 로딩 되지 않는다.
     // new A();
      System.out.println("-------------------------");
      new A(); // static 블록을 다시 실행하지 않는다.
      Class.forName("com.eomcs.oop.ex03.Exam0646$A");
    }
}





