package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

class Score{
  String name;
  int a;
  int b;
  int c;
  int sum;
  float aver;
}

public class Test01_1 {
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    final int SIZE = 3;
    Score[] score = new Score[SIZE];
    for (int i = 0; i < SIZE; i++) {
      score[i] = new Score();
    }
    int count = 0;
    while (count < 3) {
      System.out.print("입력? ");
      Score scores = new Score();
      scores.name = keyboard.next();
      scores.a = keyboard.nextInt();
      scores.b = keyboard.nextInt();
      scores.c = keyboard.nextInt();
      scores.sum = scores.a + scores.b + scores.c;
      scores.aver = (float)scores.sum / 3; 
      score[count++] = scores;
    }
    keyboard.close();
    System.out.println("-----------------------------------");
    for (int i = 0; i < count; i++) {
      Score scores = score[i];
      System.out.printf("%s %4d %4d %4d %4d %.2f\n",
          scores.name, scores.a, scores.b, scores.c, scores.sum, scores.aver);
    }
  }
}
