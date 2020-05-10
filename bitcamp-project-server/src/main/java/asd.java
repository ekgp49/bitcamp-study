import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class asd {
  public int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = new int[arr1.length][arr1[0].length];
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        answer[i][j] = arr1[i][j] + arr2[i][j];
      }
    }
    return answer;
  }

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i; j < prices.length - 1; j++) {
        if (prices[i] > prices[j]) {
          answer[i] = j - i + 1;
          break;
        }
        answer[i] = prices.length - i;
      }
    }
    return answer;
  }


  public static int solution(int n, String[] data) {
    // {A, C, F, J, M, N, R, T} => 8! data ex = [N~F=0, R~T>2]...
    int answer = 0;
    // list는 8!개
    List<String> line = new LinkedList<>();

    String character = "ACFJMNRT";
    perm(line, character.toCharArray(), 0, 8, 8);
    for (String str : line) {
      boolean checkTrue = false;
      System.out.println(str);
      for (int i = 0; i < data.length; i++) {
        if (check(str, 0, data[i])) {
          System.out.println(data[i]);
          System.out.println("ok");
          checkTrue = true;
        } else {
          checkTrue = false;
          break;
        }
      }
      if (checkTrue) {
        System.out.println("GOODGOODGOOD");
        answer++;
      }
    }
    return answer;
  }

  public static void perm(List<String> line, char[] arr, int depth, int n, int k) {
    if (depth == k) {
      line.add(String.valueOf(arr));
      return;
    }
    for (int i = depth; i < n; i++) {
      swap(arr, i, depth);
      perm(line, arr, depth + 1, n, k);
      swap(arr, i, depth);
    }
  }

  public static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  public static boolean check(String str, int n, String data) {
    String[] ask = data.split("");
    switch (ask[3]) {
      case ">":
        if (Math.abs(str.indexOf(ask[0]) - str.indexOf(ask[2])) - 1 > Integer.parseInt(ask[4])) {
          System.out.println(Math.abs(str.indexOf(ask[0]) - str.indexOf(ask[2])));
          System.out.println(Integer.parseInt(ask[4]));
          return true;
        } else {
          return false;
        }
      case "<":
        if (Math.abs(str.indexOf(ask[0]) - str.indexOf(ask[2])) - 1 < Integer.parseInt(ask[4])) {
          System.out.println(Math.abs(str.indexOf(ask[0]) - str.indexOf(ask[2])) - 1);
          System.out.println(Integer.parseInt(ask[4]));
          return true;
        } else {
          return false;
        }
      case "=":
        if (Math.abs(str.indexOf(ask[0]) - str.indexOf(ask[2])) - 1 == Integer.parseInt(ask[4])) {
          return true;
        } else {
          return false;
        }
    }
    return false;
  }

  public static int solution(int n) {
    int answer = n;
    int oneCount = 0;
    String str = Integer.toBinaryString(n);
    String str2 = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        oneCount++;
      }
    }
    while (true) {
      int oneCount2 = 0;
      answer += 1;
      str2 = Integer.toBinaryString(answer);
      for (int i = 0; i < str2.length(); i++) {
        if (str2.charAt(i) == '1') {
          oneCount2++;
        }
      }
      if (oneCount2 == oneCount) {
        return answer;
      }
    }
  }

  public static int solution(int stock, int[] dates, int[] supplies, int k) {
    int count = 0;
    int suppliesDate = 0;
    int suppliesDateTerm = 0;
    for (int i = 0; i < dates.length; i++) {
      int left = 0;
      if (k - suppliesDate <= stock) {
        return count;
      }
      for (int j = i + 1; j < supplies.length; j++) {
        left += supplies[j];
      }
      if (i == dates.length - 1) {
        if (k - suppliesDate > stock) {
          return count + 1;
        } else {
          stock = stock + supplies[i];
          suppliesDateTerm = dates[i] - suppliesDate;
          suppliesDate = dates[i];
          count++;
          stock -= suppliesDateTerm;
        }
      } else if (k - suppliesDate > left) {
        stock = stock + supplies[i];
        suppliesDateTerm = dates[i] - suppliesDate;
        suppliesDate = dates[i];
        count++;
        stock -= suppliesDateTerm;
      } else if (dates[i + 1] - suppliesDate > stock) {
        stock = stock + supplies[i];
        suppliesDateTerm = dates[i] - suppliesDate;
        suppliesDate = dates[i];
        count++;
        stock -= suppliesDateTerm;
      }
    }
    return count;

  }

  public static void main(String[] args) {
    System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
  }

  public int[] solution1(int[] prices) {
    int[] answer = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[i] <= prices[j]) {
          answer[i] = j - i;
        } else {
          answer[i] = j - i;
          break;
        }
      }
    }
    answer[prices.length - 1] = 0;
    return answer;
  }

  public static int solution(int[] priorities, int location) {
    int count = 0;
    Deque<Integer> que = new ArrayDeque<>(priorities.length);

    for (int p : priorities) {
      que.offer(p);
    }
    while (!que.isEmpty()) {
      if (location == 0) {
        if (isLargest(que, que.peek())) {
          return count + 1;
        } else {
          int a = que.poll();
          System.out.println(que.offer(a));
          location = que.size() - 1;
          System.out.println(que);
          continue;
        }
      }

      if (isLargest(que, que.peek())) {
        que.poll();
        count++;
        location--;
      } else {
        que.offer(que.poll());
        location--;
      }
      System.out.println(que);
    }
    return count;
  }

  public static boolean isLargest(Deque<Integer> que, int value) {
    Iterator<Integer> iterator = que.iterator();
    while (iterator.hasNext()) {
      if (value < iterator.next()) {
        return false;
      }
    }
    return true;
  }
}
