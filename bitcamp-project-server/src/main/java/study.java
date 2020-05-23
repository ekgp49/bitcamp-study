
public class study {

  public static void main(String[] args) {
    String answer = "";
    String a = "abc";
    String b = "abcd";
    String c = "abdd";

    for (int i = 0; i < a.length(); i++) {
      char ch = a.charAt(i);
      if (b.charAt(i) == ch) {
        answer += ch;
      }
    }

    System.out.println(a.compareTo(b));

  }

  public int[] solution(int[][] v) {
    int[] answer = {};

    String a = "abc";
    String b = "abcd";

    a.compareTo(b);

    System.out.println("Hello Java");

    return answer;
  }
}
