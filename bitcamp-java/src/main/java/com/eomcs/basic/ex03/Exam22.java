package com.eomcs.basic.ex03;

public class Exam22 {

  //리터럴
  public static void main(String[] args) {
    //10진수
    System.out.println(2_3500_0000);
    System.out.println(235_000_000);
    // System.out.println(_235_0_0_0_0_0_0);
    // System.out.println(235_000_000_);

    //8진수
    System.out.println(0144);
    System.out.println(014_4);
    System.out.println(0_144);
    // System.out.println(0144_);
    // System.out.println(_0144);

    //2진수
    System.out.println(0b01100100);
    System.out.println(0B01100100);
    // System.out.println(0B_01100100);
    // System.out.println(0B01100100_);
    // System.out.println(_0B01100100);
    System.out.println(0B0110_01_00);
    
    //16진수
    System.out.println(0x64);
    System.out.println(0X64);
    // System.out.println(0x_64);
    // System.out.println(0x64_);
    // System.out.println(_0x64);
    System.out.println(0x6_4);
  }
}