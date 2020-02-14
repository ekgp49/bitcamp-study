// 스레드 재사용 - wait/notify 사용
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0140 {

  public static void main(String[] args) {

    class MyThread extends Thread {
      int count;

      public void setCount(int count) {
        this.count = count;
        synchronized (this) {
          notify();
        }
        // notify도 동기화 영역에서 호출해야 한다.
      }

      @Override
      public void run() {
        // 어떤 객체를 대상으로 여러 스레드가 동시에 사용하지 못하게 할 것인지 지정해야 한다
        // 동기화 블록 문법:
        // synchronized(접근 대상) {...}
        synchronized (this) {
          System.out.println("스레드 시작함");
          try {
            while (true) {
              System.out.println("스레드 대기중");
              wait();
              // 스레드를 시작하자 마자 일단 작업 지시를 기다리게 한다
              // wait()는 반드시 동기화 영역 안에서
              // 호출해야 한다.
              // 동기화 블록?
              // => synchronized로 선언된 메서드
              // => synchronized로 묶인 블록
              //
              // 기다림을 끝내는 방법?
              // => notify를 통해 기다림이 끝났다는 것을 알림받아야 한다
              System.out.println("카운트 시작");
              for (int i = count; i > 0; i--) {
                System.out.println("==> " + i);
                Thread.sleep(1000);
              }
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
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


