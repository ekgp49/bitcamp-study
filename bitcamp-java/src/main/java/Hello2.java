import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Hello2 {
  public static void main(String[] args) {
    Integer[] a = {2, 3, 5, 5, 7, 3, 55, 4, 3, 2, 5, 5, 3, 5, 4, 6, 2, 5, 4, 1, 3};
    int[] b = {2, 4, 5};
  }

  public static Integer[] solution() {
    Deque<Integer> d = new LinkedList<>();
    d.add(1);
    d.add(2);
    d.add(3);
    d.add(4);
    d.add(5);


    Integer[] answer = new Integer[d.size()];
    answer = d.toArray(answer);

    return answer;
  }

  public static int[] solution2() {
    Deque<Integer> d = new LinkedList<>();
    d.add(1);
    d.add(2);
    d.add(3);
    d.add(4);
    d.add(5);


    int[] answer = new int[d.size()];
    answer = d.stream().mapToInt(i -> i).toArray();
    return answer;
  }

  // 체육복
  public static int solution(int n, int[] lost, int[] reserve) {
    List<Integer> lostList = new LinkedList<>();
    List<Integer> have2 = new LinkedList<>();

    for (int i = 0; i < lost.length; i++) {
      lostList.add(lost[i]);
    }

    for (int i = 0; i < reserve.length; i++) {
      have2.add(reserve[i]);
    }

    // 두개있는데 하나 잃어버린애들
    for (int i = 0; i < lost.length; i++) {
      int lostNo = lost[i];
      if (have2.contains(lostNo)) {
        have2.remove(have2.indexOf(lostNo)); // 이제 하나가짐
        lostList.remove(lostList.indexOf(lostNo)); // 적어도 한개 가졌으니 제외함
      }
    }

    // lostList엔 이제 0개인 애들만 있음
    // 번호 +-1인 애가 2개 있으면 하나 받아먹음
    int count = 0; // 받아먹는 놈들 있으면 카운트
    for (int i = 0; i < lostList.size(); i++) {
      int lostNo = lostList.get(i);
      if (have2.contains(lostNo - 1)) {
        have2.remove(have2.indexOf(lostNo - 1));
        count++;
      } else if (have2.contains(lostNo + 1)) {
        have2.remove(have2.indexOf(lostNo + 1));
        count++;
      }
    }
    int lostPeople = lostList.size() - count;

    return n - lostPeople;
  }

  // 문자열
  public boolean solution(String s) {
    boolean answer = true;

    try {
      if (s.length() == 6 || s.length() == 4) {
        Integer.parseInt(s);
      } else {
        answer = false;
      }
    } catch (Exception e) {
      answer = false;
    }

    return answer;
  }

  // 나누어 떨어지는 숫자 배열
  public int[] solution(int[] arr, int divisor) {
    List<Integer> arr1 = new ArrayList<>();
    for (int no : arr) {
      if (no % divisor == 0) {
        arr1.add(no);
      }
    }
    if (arr1.size() == 0)
      arr1.add(-1);
    int[] answer = arr1.stream().mapToInt(i -> i).toArray();
    Arrays.sort(answer);
    return answer;
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


    System.out.println(person1.size());
    System.out.println(person2.size());
    System.out.println(person3.size());
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
    System.out.println(count1);
    System.out.println(count2);
    System.out.println(count3);
    HashMap<String, Integer> map = new HashMap<>();
    map.put("1", count1);
    map.put("2", count2);
    map.put("3", count3);

    Integer[] mems = {map.get("1"), map.get("2"), map.get("3")};
    Arrays.sort(mems);
    System.out.println("---------");
    System.out.println(mems[0]);
    System.out.println(mems[1]);
    System.out.println(mems[2]);

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
    System.out.println("---------------------");
    int[] answer = answer1.stream().mapToInt(i -> Integer.parseInt(i)).toArray();
    return answer;
  }


  public static int solution1(String[] s) {
    int answer = -100;
    Integer.valueOf("-100");
    return answer;
  }

  public static String[] solution(String[] strings, int n) {
    List<String> list = Arrays.asList(strings);

    HashMap<String, List<String>> charMap = new HashMap<>();
    List<String> keySort = new ArrayList<>();

    for (String str : list) {
      char s = str.charAt(n);
      String ss = Character.toString(s);
      // 인덱스 n의 문자 값이 같은 문자열끼리 모은다.
      if (!charMap.containsKey(ss)) {
        charMap.put(ss, new ArrayList<String>());
        charMap.get(ss).add(str);
      } else {
        charMap.get(ss).add(str);
      }
      if (!keySort.contains(ss)) {
        keySort.add(ss);
      }
    }

    // 인덱스 n의 문자 값이 같은 문자열끼리 모은거를 각각 정렬해준다.
    for (String key : charMap.keySet()) {
      List<String> string = charMap.get(key);
      Collections.sort(string);
    }

    // 키를 정렬해준다 => a, b, c, d ...
    Collections.sort(keySort);

    List<String> answers = new ArrayList<>();
    for (String s : keySort) {
      answers.addAll(charMap.get(s));
    }

    String[] answer = new String[answers.size()];
    for (int i = 0; i < answers.size(); i++) {
      answer[i] = answers.get(i);
    }

    return answer;
  }

  public String[] solutionxx(String[] strings, int n) {
    Arrays.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.charAt(n) > s2.charAt(n))
          return 1;
        else if (s1.charAt(n) == s2.charAt(n))
          return s1.compareTo(s2);
        else if (s1.charAt(n) < s2.charAt(n))
          return -1;
        else
          return 0;
      }
    });
    return strings;
  }

}
