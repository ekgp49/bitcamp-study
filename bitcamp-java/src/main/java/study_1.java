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
    Arrays.sort(strs);
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

  public static void main(String[] args) {
    System.out.println(solution2("ZasdAZaabcdZe"));
  }
}
