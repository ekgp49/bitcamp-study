// 캡슐화 문법 사용 후 - 캡슐화와 게터/세터
package com.eomcs.oop.ex07.a;

class Score4 {

  // 실무에서는 보통 필드의 직접접근을 막는다.
  // 가능한 세터를 통해 값을 설정하도록 유도하고
  // 게터를 통해 값을 조회하도록 유도한다.
  // 그래서 name 필드 처럼 굳이 세터나 게터가 필요 없는 경우에도 세터/게터를 만든다. 
  // => 즉 필드는 캡슐화 문법을 통해 외부의 접근을 제한하고 세터/게터 메서드를 통해 값을 설정/조회하게 만든다.
  // => name, kor, eng, math 필드같은 경우 값을 설정하고 조회도 해야하기 때문에 게터/세터가 모두 있다.
  // sum이나 aver 필드같은경우 값을 조회만 해야하기 때문에 게터만 있다.
  // 즉, 모든 필드의 게터/세터를 만드는게 아니다.
  
  // 용어
  // => name, kor, eng, math, sum, aver는 필드라 부른다.
  // => getXXX()/setXXX()는 프로퍼티(property)라 부른다
  // 필드를 프로퍼티라 부르는게 아니라 게터/세터를 프로퍼티라 부르는 것이다.
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }

  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }

  public void setMath(int math) {
    this.math = math;
    this.compute();
  }
  
  public int getKor() {
    return this.kor;
  }

  public int getEng() {
    return this.eng;
  }

  public int getMath() {
    return this.math;
  }


  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}

public class Exam0311 {

  public static void main(String[] args) {
    Score4 s1 = new Score4();
    s1.setName("옹이");
    s1.setKor(80);
    s1.setEng(90);
    s1.setMath(85);
    
    s1.setKor(75);
    // => 이제 필드값 바뀌어도 알아서 compute() 실행되고 값이 반영됨.
    
    // 이제 kor, eng, math도 비공개모드이기 떄문에 값을 조회하려면 getter를 사용해야 한다.
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        s1.getName(), s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAver());
  }
}
