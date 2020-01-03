// 다형성 - 다형적 변수의 활용
package com.eomcs.oop.ex06.a;

public class Exam0411 {

    // Sedan과 Truck의 모델명과 cc를 출력하라!
    
    // 다형적 변수가 없다면?
    // Sedan의 모델명과 cc를 출력하는 메서드와 
    // Truck의 모델명과 cc를 출력하는 메서드를 모두 만들어야 하는 번거로움이 있다.
    public static void printSedan(Sedan sedan) {
        System.out.printf("모델명: %s\n", sedan.model);
        System.out.printf("cc: %d\n", sedan.cc);
        System.out.println("-------------------------");
    }
    public static void main(String[] args) {
        Sedan car1 = new Sedan();
        car1.model = "티코";
        car1.cc = 800;
        
        printSedan(car1);
        
        Truck car2 = new Truck();
        car2.model = "타이탄II";
        car2.cc = 10000;
        
        //printSedan(car2); // 컴파일 오류!
        // Truck 인스턴스에서 model과 cc 값을 꺼내서 프린트할 메서드를 따로 만들어야 한다.
        
    }

}




