// Object 클래스의 메서드를 오버라이딩 하기 - hashCode()
package com.eomcs.oop.ex06.d;

public class Exam0230 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    public Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.sum = kor + eng + math;
      this.aver = this.sum / 3f;
    }

    // 인스턴스가 다르더라도 데이터가 같으면 같은 해시 값을 리턴하도록 오버라이딩 해보자!
    @Override
    public int hashCode() {
      // 가장 간단한 방법은 모든 값을 문자열로 만들어 붙인 다음에
      // String 클래스에 있는 hashCode()를 사용하는 것이다.
      // 왜? String 클래스에 있는 hashCode()는 문자열이 같은 경우 
      //     같은 해시 값을 리턴하도록 이미 오버라이딩 되어 있기 때문이다.
      String value = String.format("%s,%d,%d,%d,%d,%.1f", 
          this.name, this.kor, this.eng, this.math,
          this.sum, this.aver);
      
      // 데이터가 같으면 문자열이 같을 것이고, 문자열이 같으면 해시코드의 리턴값도 같을 것이다.
      return value.hashCode();
    }
  }

  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 100, 100);
    Score s2 = new Score("홍길동", 100, 100, 100);
    Score s3 = new Score("홍길동", 100, 90, 100);
    Score s4 = new Score("홍길동", 90, 100, 100);
    
    // 인스턴스는 모두 다르다.
    System.out.println(s1 == s2);
    System.out.println(s1 == s3);
    System.out.println(s1 == s4);
    System.out.println(s2 == s3);
    System.out.println(s2 == s4);
    System.out.println(s3 == s4);
    System.out.println("-------------------------------------");
    // s1과 s2는 비록 인스턴스가 다르지만 데이터가 같기 때문에 같은 해시코드값을 리턴한다.
    
    // 같은 값을 가질 때 같은 해시값을 리턴하도록 
    // hashCode()를 오버라이딩 했기 때문에
    // 다음 출력은 같은 해시 값을 출력할 것이다.
    System.out.printf("%d, %d, %d, %d\n", 
        s1.hashCode(), s2.hashCode(), s3.hashCode(), s4.hashCode());

    // hashCode()의 리턴 값을 비교하여 두 인스턴스의 문자열(데이터)이 같은지 알아낼 수도 있다.
    System.out.println(s1.hashCode() == s2.hashCode());
    
    // 즉 두 개의 인스턴스가 같은 데이터를 갖고 있는지 비교하기 위해서 hashCode()를 오버라이딩하는 것이다.

  }
}






