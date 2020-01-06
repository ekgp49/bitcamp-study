// 캡슐화 문법 사용 후 - 개발자가 특정 필드를 직접 접근하지 못하게 막기
package com.eomcs.oop.ex07.a;

class Score2 {
  String name;
  int kor;
  int eng;
  int math;

  // sum이나 aver필드는 다른 값은 연산한 결과를 보관하기 때문에 직접 접근하여 값을 변경하는 것을 허용하면 안된다.
  // 허용하는 순간 개발자의 잘못된 명령으로 국영수점수와 합계평균이 서로 맞지 않는 문제가 발생할 수 있다.
  // 그래서 자바는 외부 필드나 메서드의 외부접근 범위를 조정하는 문법을 제공한다.
  // 그 문법을 캡슐화(encapsulation)라 부른다.
  private int sum;
  private float aver;
  
  //근데 값을 변경 못해도 외부에서 해당 값들을 조회할 수는 있는 방법/수단(method)을 제공해아한다.
  // => 보통 이렇게 필드의 값을 조회하는 용도로 사용하는 메서드의 경우
  // 메서드의 용도를 이해하기 쉽도록 get필드명() 형태로 이름을 짓는다.
  // => getter라고 부른다. 그리고 public으로 설정한다.(공개모드)
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

public class Exam0210 {
  public static void main(String[] args) {
    Score2 s1 = new Score2();
    s1.name = "옹길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    s1.compute();
    // 계산을 한 후 임의적으로 합계나 평균을 변경한다면?
  //  s1.sum = 300; // 컴파일 오류
//    s1.aver = 100f; // 컴파일 오류
    // => sum과 aver 필드는 private 접근만 허용한다. 즉 클래스의 멤버만 접근할 수 있고 클래스 외부에선 접근 못함
    // => 다음과 같이 임의로 접근하여 값을 변경할 수 없다. 
    
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        s1.name, s1.kor, s1.eng, s1.math, s1.getSum(), s1.getAver());
  }
}
