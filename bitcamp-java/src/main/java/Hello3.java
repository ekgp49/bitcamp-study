import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Hello3 {

  public int solution(int[][] board, int[] moves) {
    Stack<Integer> stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < moves.length; i++) {
      int select = moves[i] - 1;
      int depth = 0;
      int doll = 0;
      while (depth < board.length) {
        if (board[depth][select] == 0) {
          depth++;
          continue;
        }
        // 인형이 잡혔을 경우
        doll = board[depth][select];
        if (!stack.empty() && stack.lastElement() == doll) {
          stack.pop();
          board[depth][select] = 0;
          count += 2;
          break;
        } else {
          stack.push(doll);
          board[depth][select] = 0;
          break;
        }
      }
    }
    return count;
  }

  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i <= n / 2; i++) {
      if (n % i == 0) {
        answer += i;
      }
    }
    return answer + n;
  }

  boolean solution(String s) {
    String ss = s.toLowerCase();
    return ss.chars().filter(v -> {
      return v == 'y';
    }).count() == ss.chars().filter(v -> {
      return v == 'p';
    }).count(); // 아래 메서드에 비해서 실행시간이 훨씬 오래걸림 5배정도....
  }

  boolean solution1(String s) {
    String ss = s.toLowerCase();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (ss.charAt(i) == 'p') {
        count++;
      } else if (ss.charAt(i) == 'y') {
        count--;
      }
    }
    return count == 0;
  }

  public String solution3(String s) {
    if (s.length() % 2 != 0) {
      return String.valueOf(s.charAt(s.length() / 2));
    } else {
      return String.valueOf(s.charAt(s.length() / 2 - 1))
          + String.valueOf(s.charAt(s.length() / 2));
    }
  }

  public static String solution4(String s) {
    char[] a = s.toCharArray();
    Arrays.sort(a);
    return new StringBuilder(new String(a)).reverse().toString();
  }

  public static String solution5(String s) {
    char[] chars = s.toUpperCase().toCharArray();
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
      if (chars[i] == ' ') {
        count = 1;
        continue;
      }
      if (Character.isLetter(chars[i])) {
        if (count % 2 == 0) {
          chars[i] = Character.toLowerCase(chars[i]);
        }
        count++;
      }
    }
    return new String(chars);
  }

  public static long solution112(long n) {
    char[] c = String.valueOf(n).toCharArray();
    Arrays.sort(c);
    return Long.parseLong(new StringBuilder().append(String.valueOf(c)).reverse().toString());
  }

  public static int[] solution1111(long n) {
    List<Long> list = new ArrayList<>();
    while (n > 0) {
      list.add(n % 10);
      n /= 10;
    }
    return list.stream().mapToInt(i -> i.intValue()).toArray();
  }// 아래 코드와 같음

  public int[] solution(long n) {
    String[] nums =
        new StringBuilder().append(String.valueOf(n).toCharArray()).reverse().toString().split("");
    int[] answer = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      answer[i] = Integer.valueOf(nums[i]);
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution1111(1254545350)[0]);
  }
}
