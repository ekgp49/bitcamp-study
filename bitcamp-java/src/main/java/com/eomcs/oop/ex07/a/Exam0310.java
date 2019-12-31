// 캡슐화 문법 사용 후 - 필드의 값을 변경할 때마다 특정 작업을 수행하게 하기(메서드로 만들어 써야한다는 뜻)
package com.eomcs.oop.ex07.a;

class Score3 {
  String name;

  private int kor;
  private int eng;
  private int math;
  // 필드에 직접 접근 못하게 막고 메서드를 통해 필드값을 설정하게 하라 
  // => set필드명()으로 이름을 짓는다. setter라 부른다.
  // => 외부에서 호출할 수 있도록 public 공개모드로 설정한다.
  // 필드를 비공개로 막으면 값을 조회할 수 없기 때문에 getter를 추가해야 한다.
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


  private int sum;
  private float aver;

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

public class Exam0310 {

  public static void main(String[] args) {
    Score3 s1 = new Score3();
    s1.name = "옹길동";
    s1.setKor(80);
    s1.setEng(90);
    s1.setMath(85);
    
    s1.setKor(75);
    // => 이제 필드값 바뀌어도 알아서 compute() 실행되고 값이 반영됨.
    
    // 이제 kor, eng, math도 비공개모드이기 떄문에 값을 조회하려면 getter를 사용해야 한다.
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
        s1.name, s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAver());
  }
}
