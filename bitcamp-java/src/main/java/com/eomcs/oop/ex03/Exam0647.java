// 초기화 블록 - 클래스 블록 = 스태틱 블록
package com.eomcs.oop.ex03;

public class Exam0647 {
    
    public static class A {
        static int a;
        static void m() {}
        
        A() {
          System.out.println("A() 11111");
        }
        {
          System.out.println("인스턴스{} 11111");
        }
        // 스태틱 블록은 클래스가 로딩된 후에 자동으로 순서대로 실행된다.
        static {
            System.out.println("Static{} 11111");
        }
        
        {
          System.out.println("인스턴스{} 222222");
        }
        
        static {
            System.out.println("Static{} 22222");
        }
    }
    
    public static void main(String[] args) throws Exception {
        // 클래스가 로딩되는 경우
        new A();
        System.out.println("--------------");
        
        // 클래스는 한번 로딩 되었기 때문에 스태틱블록은 다시 실행되지 않는다.
        new A();
    }
}





