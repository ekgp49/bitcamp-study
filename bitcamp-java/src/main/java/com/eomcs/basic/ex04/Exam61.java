package com.eomcs.basic.ex04;

public class Exam61 {
  public static void main(String[] args) {
    //배열 사용 전
    int kor, eng, math, soc, mus;

    //배열 사용 후
    int[] score = new int[5];

    //배열 값 저장 방법
    score[0] = 100;
    score[1] = 90;
    score[2] = 80;
    score[3] = 70;
    score[4] = 60;
    
  

    int[] arr1; 
    
    arr1 = new int[5];
    arr1[0] = 100;
    arr1[1] = 100;

    System.out.println(arr1[0]);


    int[] arr2;

    arr2 = arr1;
    
    System.out.println(arr1[0]);
    arr2[0] = 300;
    System.out.println(arr1[0]);

    System.out.println(arr1[2]); //0나옴. 배열 인스턴스의 각 항목은 생성되는 순간 기본 값으로 자동 초기화된다.


    int[] arr3;
    arr3 = new int[3];
    arr3[0] = 30;

    arr2 = arr3;
    System.out.println(arr2[0]);

    arr1 = arr2;
    System.out.println(arr1[0]);

    int[] arr4 = new int[3];
    arr4[0] = 100;
    arr4[1] = 90;
    arr4[2] = 80;


    int[] arr5 = new int[] {100, 90, 80};
    // int[] arr6 = new int[3] {100, 90, 80};

    int[] arr7 = {100, 90, 80};

    int[] arr8;
    // arr8 = {100, 90, 80}; 컴파일 오류
    arr8 = new int[] {100, 90, 80};
  }
}