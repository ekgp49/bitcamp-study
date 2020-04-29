import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class study_1 {
  // 별 찍기
  public static void main1(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    for (int i = 0; i < b; i++) {
      for (int j = 0; j < a; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  // 문자 내림차순으로 정렬하기
  public static String solution(String s) {
    char[] charArr = s.toCharArray();
    Arrays.sort(charArr);
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      list.add(charArr[i]);
    }
    Collections.reverse(list);
    String answer = "";
    for (Character c : list) {
      answer += c;
    }
    return answer;
  }

  // 문자열 내림차순 정렬2
  public static String solution2(String s) {
    String[] strs = s.split("");
    Arrays.sort(strs, Collections.reverseOrder());
    return String.join("", strs);
  }


  // 모의고사
  public static int[] solution222(int[] answers) {
    List<Integer> first = new LinkedList<>();
    List<Integer> second = new LinkedList<>();
    List<Integer> third = new LinkedList<>();

    for (int i = 1; i <= 5; i++) {
      first.add(i);
    }

    Integer[] int2 = {2, 1, 2, 3, 2, 4, 2, 5};
    second.addAll(Arrays.asList(int2));


    for (int i = 0; i < 10; i++) {
      if (i < 2) {
        third.add(i, 3);
      } else if (i < 4) {
        third.add(i, 1);
      } else if (i < 6) {
        third.add(i, 2);
      } else if (i < 8) {
        third.add(i, 4);
      } else if (i < 10) {
        third.add(i, 5);
      }
    }

    int questions = answers.length;
    List<Integer> person1 = new ArrayList<>();
    List<Integer> person2 = new ArrayList<>();
    List<Integer> person3 = new ArrayList<>();

    for (; person1.size() < questions;) {
      person1.addAll(first);
    }
    for (; person2.size() < questions;) {
      person2.addAll(second);
    }
    for (; person3.size() < questions;) {
      person3.addAll(third);
    }

    Integer count1 = 0;
    Integer count2 = 0;
    Integer count3 = 0;

    for (int i = 0; i < questions; i++) {
      if (person1.get(i) == answers[i]) {
        count1++;
      }
      if (person2.get(i) == answers[i]) {
        count2++;
      }
      if (person3.get(i) == answers[i]) {
        count3++;
      }
    }
    HashMap<String, Integer> map = new HashMap<>();
    map.put("1", count1);
    map.put("2", count2);
    map.put("3", count3);

    Integer[] mems = {map.get("1"), map.get("2"), map.get("3")};
    Arrays.sort(mems);

    List<String> answer1 = new ArrayList<>();

    if (mems[0].equals(mems[2])) {
      answer1.add("1");
      answer1.add("2");
      answer1.add("3");
      //
    } else if (mems[1].equals(mems[2])) {
      System.out.println(mems[1] == mems[2]);
      // false. 이래서 ==말고 equals 써야함 127 이하의 값 비교는 true
      System.out.println(mems[1].equals(mems[2])); // true
      for (String key : map.keySet()) {
        if (mems[0].equals(map.get(key))) {
          if (key == "1") {
            answer1.add("2");
            answer1.add("3");
          } else if (key == "2") {
            answer1.add("1");
            answer1.add("3");
          } else if (key == "3") {
            answer1.add("1");
            answer1.add("2");
          }
        }
      }
    } else {
      answer1.add("1");
      answer1.add("2");
      answer1.add("3");
      for (String key : map.keySet()) {
        if (mems[0] == map.get(key)) {
          answer1.remove(key);
        }
        if (mems[1] == map.get(key)) {
          answer1.remove(key);
        }
      }
    }
    int[] answer = answer1.stream().mapToInt(i -> Integer.parseInt(i)).toArray();
    return answer;
  }



  // 모의고사2
  public int[] solution(int[] answers) {
    int[] answer = {0, 0, 0};
    int[] person1 = new int[] {1, 2, 3, 4, 5};
    int[] person2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
    int[] person3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == person1[i % 5]) {
        answer[0]++;
      }
      if (answers[i] == person2[i % 8]) {
        answer[1]++;
      }
      if (answers[i] == person3[i % 10]) {
        answer[2]++;
      }
    }
    int max = Arrays.stream(answer).max().getAsInt();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < answer.length; i++) {
      if (answer[i] == max) {
        list.add(i + 1);
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

  public long solution(long n) {
    if (Math.sqrt(n) == Math.round(Math.sqrt(n))) {
      return (long) ((Math.sqrt(n) + 1) * (Math.sqrt(n) + 1));
    }
    return -1;
  }

  // 두 수의 최대공약수, 최소공배수 리턴하기 => 두 수의 곱/최대공약수 = 최소공배수
  public static int[] solution(int n, int m) {
    int min = 1;
    int max = n * m; // 최대공약수가 1인 경우
    if (n > m) {
      int temp = n;
      n = m;
      m = temp;
    }
    for (int i = 2; i <= n; i++) {
      if (m % i == 0 && n % i == 0) {
        min = i;
      }
    }
    return new int[] {min, max / min};
  }



  public static long[] solution1(int x, int n) {
    List<Long> list = new ArrayList<>();
    long y = x;
    for (int i = 0; i < n; i++) {
      list.add(y);
      y += x;
    }
    return list.stream().mapToLong(i -> i).toArray();
  }

  // 배열 갯수가 정해졌는데 굳이 List 만들필요가 없음, List 안쓰는게 훨씬 빠르기도 함
  public static long[] solution2(int x, int n) {
    long[] answer = new long[n];
    answer[0] = x;
    for (int i = 1; i < n; i++) {
      answer[i] = answer[i - 1] + x;
    }
    return answer;
  }

  // 콜라츠 추측 => 곱하기를 하면 int값이 너무 길어져서 짤릴수 있음 -> long으로 바꿔줘야 함
  public static int solution(int num) {
    int answer = 0;
    long longNum = num;
    while (longNum != 1) {
      if (answer > 500) {
        return -1;
      }
      if (longNum % 2 == 0) {
        longNum = longNum / 2;
      } else if (longNum % 2 != 0) {
        longNum = longNum * 3 + 1;
      }
      answer++;
    }
    return answer;
  }

  public static String solution111(String phone_number) {
    String answer = "";
    for (int i = 0; i < phone_number.length() - 4; i++) {
      answer += "*";
    }
    return answer + phone_number.substring(phone_number.length() - 4);
  }

  public static String solution1111(String phone_number) {
    return phone_number.replaceAll(".(?=.{4})", "*");
  }

  public static boolean solution2(int x) {
    int sum = 0;
    int y = x;
    while (x > 0) {
      sum += x % 10;
      x = x / 10;
    }
    if (y % sum == 0) {
      System.out.println(sum);
      return true;
    }
    return false;
  }

  public int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = new int[arr1.length][arr1[0].length];
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        answer[i][j] = arr1[i][j] + arr2[i][j];
      }
    }
    return answer;
  }

  public int solution(int[] d, int budget) {
    int answer = 0;
    Arrays.sort(d);
    for (int i = 0; i < d.length && d[i] <= budget; i++) {
      budget -= d[i];
      answer++;
    }
    return answer;
  }

  public static int[] solution5(int N, int[] stages) {
    int[] answer = new int[N + 1];
    int[] failRate = new int[N + 1]; /* 인덱스를 1~N 까지 쓸것임 */
    for (int i = 1; i <= N; i++) {
      int clear = 0;
      int fail = 0;
      for (int j = 1; j < stages.length/* 플레이어 수 */; j++) {
        System.out.println(i);
        System.out.println(j);
        if (stages[j] >= i) {
          clear++;
        }
        if (stages[j] == i) {
          fail++;
        }
      }
      failRate[i] = fail / clear;
    }
    int[] arr = Arrays.copyOf(failRate, failRate.length);
    Arrays.sort(arr);
    System.out.println(arr.length);
    System.out.println(failRate.length);
    System.out.println(answer.length);
    // int no = 0;
    // for (int i = arr.length - 1; i > 0; i--) {
    // for (int j : arr) {
    // if (failRate[i] == j) {
    // answer[no++] = i;
    // }
    // }
    // }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution5(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
  }
}
