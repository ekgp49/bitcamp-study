package com.eomcs.basic.ex03;

public class Exam42 {

  //리터럴
  public static void main(String[] args) {
   System.out.println(0x41); //앞의 00은 생략 가능
   System.out.println(0xac00);
   
   System.out.println((char)0x41);
   System.out.println((char)0xac00);
    
   for (int i = 0; i < 11172; i++) {
     if(i % 80 == 0) {
        System.out.println();
     } 
     System.out.print((char)(0xac00 + i));
   }
  }
}