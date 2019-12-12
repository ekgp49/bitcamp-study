package com.eomcs.basic.ex99;

public class Exam11 {
  public static void main(String[] args) {
  
    System.out.println(100);
    System.out.println(3.14);
    System.out.println(true);
    System.out.println('가');
    System.out.println("안녕");
  
    System.out.println();

    System.out.print(100);
    System.out.print(3.14);
    System.out.print(true);
    System.out.print('가');
    System.out.print("안녕");
  
    System.out.print('\n');

    System.out.print("OK!\n");
    System.out.print("NO!");

    System.out.printf("\n이름 : %s", "홍길동");
    System.out.printf("\n나이 : %d", 20);
    
    System.out.printf("\n이름(나이) : %s(%d)", "홍길동", 20);
    
    // %d : decimal
    // %x : hexadecimal
    // %c : character
    System.out.printf("\n %d, %x, %c", 65, 65, 65);

    System.out.printf("\n %1$d, %1$x, %1$c", 65);

    System.out.printf("\n 재직자 : %b", true);
    System.out.printf("\n 나이 : %d", 20);

    
    System.out.printf("\n이름 : [%s]", "김다혜");
    System.out.printf("\n이름 : [%20s]", "김다혜");
    System.out.printf("\n이름 : [%-20s]", "김다혜");

    System.out.printf("\n숫자 : [%d]", 12345);
    System.out.printf("\n숫자 : [%10d]", 12345);
    System.out.printf("\n숫자 : [%-10d]", 12345);
    System.out.printf("\n숫자 : [%010d]", 12345);
    System.out.printf("\n숫자 : [%+010d], [%+010d]", 12345, -12345);


    java.util.Date today = new java.util.Date();
    today.setDate(9);

    System.out.printf("\n%s", today);
    System.out.printf("\n%tY, %ty", today, today);
    System.out.printf("\n%tB, %tb", today, today); //December , Dec
    System.out.printf("\n%tm", today);
    System.out.printf("\n%td, %te", today, today); //09, 9
    System.out.printf("\n%tA, %ta", today, today); //Monday, Mon
    System.out.printf("\n%tH, %tI", today, today);
    System.out.printf("\n%tM", today);
    System.out.printf("\n%tS, %tL, %tN", today, today, today); //초, 밀리초, 나노초
    System.out.printf("\n%tp, %Tp", today, today); // pm, PM

    // 2019-12-12 12:37:45
    // System.out.printf("\n%tY-%tm-%td %tH:%tM:%tS", today, today, today, today, today, today);

    System.out.printf("\n%1$tY-%1$tm-%1$td %1$Tp %1$tH:%1$tM:%1$tS", today);


    String str;

    str = String.format("\n%1$tY-%1$tm-%1$td %1$Tp %1$tH:%1$tM:%1$tS", today);
    System.out.println(str);
  }
}