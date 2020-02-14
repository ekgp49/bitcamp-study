// 멀티 스레드 재사용
package com.eomcs.concurrent.ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam0210 {
  static class MyThread extends Thread {
    ThreadPool pool;
    int count;

    public MyThread(String name, ThreadPool pool) {
      super(name);
      this.pool = pool;
    }

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
            // 작업하라는 알림이 올 때까지 기다린다
            wait();
            // 작업을 실행한다
            for (int i = count; i > 0; i--) {
              System.out.printf("[%s] %d\n", getName(), i);
              Thread.sleep(1000);
            }
            // 작업이 끝나면 스레드풀로 돌아간다.
            pool.add(this);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  interface ThreadPool {
    Thread get();

    void add(Thread obj);
  }

  static class MyThreadPool implements ThreadPool {
    ArrayList<MyThread> list = new ArrayList<>();

    public MyThreadPool() {
      MyThread t1 = new MyThread("1번", this);
      t1.start();
      list.add(t1);

      MyThread t2 = new MyThread("2번", this);
      t2.start();
      list.add(t2);

      MyThread t3 = new MyThread("3번", this);
      t3.start();
      list.add(t3);
    }

    // ThreadPool에서 한개의 Thread를 꺼낸다.
    @Override
    public MyThread get() {
      if (list.size() > 0) {
        return list.remove(0);
      }
      return null;
    }

    // 스레드를 다 쓴 후에는 다시 스레드 풀에 돌려준다.
    @Override
    public void add(Thread t) {
      list.add((MyThread) t);
    }
  }

  public static void main(String[] args) {


    MyThreadPool threadPool = new MyThreadPool();

    Scanner keyscan = new Scanner(System.in);

    while (true) {
      System.out.println("카운트? ");
      String str = keyscan.nextLine();
      if (str.equals("quit")) {
        break;
      }
      int count = Integer.parseInt(str);
      // 스레드 풀에서 스레드를 한 개 꺼낸다.
      MyThread t = threadPool.get();
      if (t == null) {
        System.out.println("남는 스레드가 없습니다");
        continue;
      }
      t.setCount(count);

    }
    System.out.println("main Thread 종료");
    keyscan.close();
  }
}


