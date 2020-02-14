// 스레드 재사용 - sleep/timeout을 이용한 스레드 재사용
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0130 {

  public static void main(String[] args) {

    class MyThread extends Thread {
      int count;
      boolean enable;

      public void setCount(int count) {
        this.count = count;
        // 카운트를 설정하면 스레드의 작업을 허락하자
        this.enable = true;
      }

      @Override
      public void run() {
        System.out.println("스레드 시작함");
        try {
          // 스레드를 재사용하려면 다음과 같이 run() 메서드가 종료하지 않도록 해야한다.
          while (true) {
            // 사용자가 카운트 값을 입력할 시간을 주기 위해
            // 10초정도 스레드를 멈춘다
            System.out.println("스레드 10초 잔다");
            Thread.sleep(10000);

            // 무조건 작업하지 말고 enable이 true일 때만 작업하게 하자
            if (!enable) {
              continue;
            }

            System.out.println("카운트 시작");
            for (int i = count; i > 0; i--) {
              System.out.println("==> " + i);
              Thread.sleep(1000);
            }
            // 작업이 끝나면 비활성 상태로 설정하고 10초동안 잠든다
            enable = false;
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }

    MyThread t = new MyThread();

    t.start(); // 미리 스레드를 시작시켜 놓는다.

    Scanner keyscan = new Scanner(System.in);

    while (true) {
      System.out.println("카운트? ");
      String str = keyscan.nextLine();
      if (str.equals("quit")) {
        break;
      }
      int count = Integer.parseInt(str);
      t.setCount(count); // 스레드의 카운트 값을 변경한다

    }
    System.out.println("main Thread 종료");
  }
}


