// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0111 {

    public static void main(String[] args) throws Exception {
        // 생성자를 호출하여 문자열 인스턴스를 초기화시킨다.
      
        // => 문자열 리터럴을 사용하여 String 인스턴스를 초기화시키기
        String s1 = new String("Hello");
        
        // => char[]을 사용하여 String 인스턴스를 초기화시키기
        char[] chars = new char[] {'H', 'e', 'l', 'l', 'o'};
        String s2 = new String(chars);
        
        System.out.printf("%s, %s\n", s1, s2);
        
        // => 바이트 배열을 가지고 String 인스턴스 초기화시키기
        // => '가각똘똥' 문자를 EUC-KR 코드 값으로 바이트 배열을 만든다.
        byte[] bytes = {
           (byte)0x48, (byte)0x65, 
            (byte)0x6c, (byte)0x6c, (byte)0x6f};
        
        String s3 = new String(bytes);
        System.out.println(s3);
        // => EUC-KR 코드 값이 들어 있는 바이트 배열을 가지고 스트링 인스턴스를 초기화시킨다.
        //    즉 유니코드(UTF-16) 배열에 저장한다.
        // 출력이 깨지는 이유? 
        // EUC-KR 코드 값이 들어 있는 바이트 배열이 제대로 유니코드 배열로 저장되지 않았기 때문.
        // 이 생성자는 바이트 배열에 들어 있는 값이 ISO-8859-1 이라고 간주하기 때문이다.
        
        // 해결책?
        // String 클래스의 생성자 중에서 바이트 배열과 인코딩 정보를 함께 받는 생성자를 호출하라!
        // => 즉 bytes 배열에 EUC-KR의 코드 값이 들어 있다고 알려준다.
        //    그러면 JVM은 바이트 배열에 들어 있는 값을 제대로 유니코드 바꿀 것이다.
        String s5 = new String(bytes, "EUC-KR");
        System.out.println(s5);
    }
}

// 생성자의 활용
// => 인스턴스 변수를 초기화시키기 위해 여러 개의 생성자를 만들어 제공할 수 있다.
// => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용하면 된다. 















