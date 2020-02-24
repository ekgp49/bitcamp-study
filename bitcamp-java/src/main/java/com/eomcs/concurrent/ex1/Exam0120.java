// 멀티 스레드 적용 후
package com.eomcs.concurrent.ex1;

public class Exam0120 {

  // CPU의 시간을 쪼개서 왔다갔다하면서 동시에 실행하고픈 코드가 있다면
  // 다음과 같이 Thread를 상속받아 run()메서드에 그 코드를 두어라
  static class MyThread extends Thread {
    @Override
    public void run() {
      // 기존 실행 흐름과 분리하여 따로 실행시킬 코드를
      // 이 메서드에 둔다.
      for (int i = 0; i < 1000; i++) {
        System.out.println("==> " + i);
      }
    }
  }

  public static void main(String[] args) {
    // 동시에 실행할 코드를 담고있는 Thread 객체를 생성한다.
    // 그리고 현재 실행과 분리하여 작업을 시작시킨다
    // JVM은 이 Thread에 들어있는 코드와 다음에 진행하는 코드를 왔다갔다하면서
    // 처리할 것이다.
    new MyThread().start();

    for (int i = 0; i < 1000; i++) {
      System.out.println(">>> " + i);
    }
  }

}

// # 멀티태스킹 (multi-tasking)
// - 한개의 CPU가 여러 코드를 동시에 실행하는 것
// - 실제는 일정한 시간을 쪼개 이 코드와 저 코드를 왔다갔다하면서 실행한다
// - 그럼에도 불구하고 외부에서 봤을때는 명령어가 동시에 실행되는 것 처럼 보인다
// - 왜? CPU 속도가 워낙 빠르기 때문이다
//
// # CPU의 실행시간을 쪼개서 배분하는 전략 : CPU Scheduling 또는 프로세스 스케줄링
// - CPU의 실행 시간을 쪼깨 코드를 실행하는 방법이다.
// - 1) 라운드로빈(Round - Robin) 방식
// - Windows OS에서 사용
// - CPU 실행시간을 일정하게 쪼개서 각 코드에 분배하는 방식
// - 2) Priority 방식
// - Unix, Linux에서 사용하는 방식
// - 우선순위가 높은 코드에 더 많은 실행시간을 배정하는 방식
// - 문제점:
// 우선순위가 낮은 프로그램인 경우 CPU 시간을 배정받지 못하는 문제가 발생했다
// 그래서 몇년이 지나도 프로그램이 실행되지 않는 겨웅가 나타났다
// 해결책?
// CPU 시간을 배정받지 못할 때마다 우선순위를 높여서
// 언젠가는 실행되도록 만들게 했다 => Aging 기법
//
// # 멀티태스킹을 구현하는 방법
// 1) 멀티 프로세싱
// - 프로세스(실행중인 프로그램)를 복제하여 분기한다.
// - 그리고 분기된 프로세스를 실행시켜서 동시에 작업을 실행시키는 방법
// - 장점:
// - 분기하기가 쉽다.
// - 즉, 구현(프로그래밍)하기가 쉽다
// - 단점:
// - 프로세스를 그대로 복제하기 때문에 프로세스가 사용하는 메모리도 그대로 복제된다.
// 한마디로 메모리 낭비가 심하다
// 복제된 프로세스는 독립적이기 때문에 실행 종료할 때도 일일히 종료해야한다.

// 2) 멀티 스레딩
// - 특정 코드만 분리하여 실행한다
// - 따라서 프로세스가 사용하는 메모리를 공유한다
// 장점:
// - 프로세스의 힙메모리를 공유하기 때문에 메모리 낭비가 적다// 스택만 분리시킴
// - 모든 스레드는 프로세스에 종속되기 때문에 프로세스를 종료하면
// 스레드도 자동 종료 된다. => 관리하기가 편하다
// 단점:
// - 프로세스 복제 방식에 비해 코드 구현이 복잡하다
//
// ## 컨텍스트 스위칭(Context Switching)
// - CPU 실행 시간을 쪼개 이코드 저코드를 실행할 때마다
// 실행 위치 및 정보(context)를 저장하고 로딩하는 과정이 필요하다.
// - 이 과정을 컨텍스트 스위칭이라 부른다.
//
// ## 스레드(Thread)
// - 실이라는 뜻
// - 한 실행 흐름을 나타낸다
// - 하나의 실은 끊기지 않은 하나의 실행의 의미한다
// ## 스레드 생성
// - 새 실을 만든다는 것이다
// 즉 새 실행 흐름을 시작하겠다는 의미다
// - CPU는 프로세스와 마찬가지로 동일한 자격을 부여하여
// 스케쥴링에 참여시킨다
// - 즉 프로세스에 종속된 스레드라고 취급하여 한 프로세스에 부여된 실행시간을
// 다시 쪼개 스레드를 실행시킨다는 것이 아니다.
// - 그냥 단독적인 프로세스처럼 동일한 실행 시간을 부여한다
//
// main() 메서드를 실행하는 기본 실행 흐름에서 새로운 실행 흐름으로 분기하고 싶다면,
// Thread 클래스에 분기해서 실행할 코드를 담으면 된다.
// 그러면 두 개의 실행 흐름이 서로 왔다 갔다 하면서 실행된다.

