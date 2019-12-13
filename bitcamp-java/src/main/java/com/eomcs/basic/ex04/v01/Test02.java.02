// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위 (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//
package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    System.out.print("가위, 바위, 보? :");

    Scanner scanner = new Scanner(System.in);
    String me = scanner.nextLine();

    int computer = (int) (Math.random() * 3); // 0,1,2 중 랜덤
    String computerHand = "";

    if (computer == 0) {
      computerHand = "가위";
    } else if (computer == 1) {
      computerHand = "바위";
    } else if (computer == 2) {
      computerHand = "보";
    } ;

    if (computerHand.equals(me)) {
      System.out.println("컴퓨터: " + computerHand + "\n=> 비겼습니다.");
    } else if (me.equals("바위")) {
      switch (computerHand) {
        case "바위":
          System.out.println("컴퓨터: " + computerHand + "\n=> 졌습니다.");
          break;
        case "보":
          System.out.println("컴퓨터: " + computerHand + "\n=> 이겼습니다.");
          break;
      }
    } else if (me.equals("가위")) {
      switch (computerHand) {
        case "바위":
          System.out.println("컴퓨터: " + computerHand + "\n=> 졌습니다.");
          break;
        case "보":
          System.out.println("컴퓨터: " + computerHand + "\n=> 이겼습니다.");
          break;
      }
    } else if (me.equals("보")) {
      switch (computerHand) {
        case "바위":
          System.out.println("컴퓨터: " + computerHand + "\n=> 이겼습니다.");
          break;
        case "가위":
          System.out.println("컴퓨터: " + computerHand + "\n=> 졌습니다.");
          break;
      }
    } else {
      System.out.println("??");
    };




    // 가위 바위
    // 가위 보
    // 가위 가위
    // 바위 가위
    // 바위 보
    // 등등 총 7가지 경우의 수 가위가위 보보 바위바위는 하나로 퉁침



    scanner.close();
  }
}

