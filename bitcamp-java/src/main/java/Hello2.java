import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Hello2 {
  public static void main(String[] args) {
    int[] a = {2, 3, 5, 5, 7, 3, 55, 4, 3, 2, 5, 5, 3, 5, 4, 6, 2, 5, 4, 1, 3};
    int[] b = {2, 4, 5};
    System.out.println(solution9999(10));
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
    for (int i = 0; i < lost.length; i++) {
      int lostNo = lost[i];
      if (have2.contains(lostNo)) {
        have2.remove(have2.indexOf(lostNo)); // 두개에서 하나 잃어버림
        lostList.remove(lostList.indexOf(lostNo)); // 그래도 적어도 한개 가졌으니 lostList에서 제외함
      }
    }
    int count = 0; // lostList중에서 have2에서 받아먹는 놈들 있으면 카운트
    for (int i = 0; i < lostList.size(); i++) {
      int lostNo = lostList.get(i); // 번호 얻어서
      if (have2.contains(lostNo - 1)) { // 앞의 번호인애들 중 have2에 있는애면 하나 줌
        have2.remove(have2.indexOf(lostNo - 1)); // 하나 줘서 have2에서 제외
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
        Pattern.compile("");
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

  public static int solution998(int n, int[] lost, int[] reserve) {
    int[] state1 = new int[n];
    int[] state2 = new int[n];

    init(state1, lost, reserve); // [2, 0, 2, 0, 2]
    init(state2, lost, reserve); // [2, 0, 2, 0, 2]

    return Math.max(fOrder(state1, n), bOrder(state2, n));
  }

  public static void init(int[] state, int[] lost, int[] reserve) {
    // 5 lost=[2, 4] reserve=[1, 3, 5]
    Arrays.fill(state, 1); // [1, 1, 1, 1, 1]
    for (int idx : lost)
      state[idx - 1]--; // [1, 0, 1, 0 , 1]
    for (int idx : reserve)
      state[idx - 1]++; // [2, 0, 2, 0, 2]
  }

  public static int fOrder(int[] state, int n) {
    fRent(state, n);
    bRent(state, n);
    return (int) Arrays.stream(state).filter(i -> i > 0).count();
  }

  public static int bOrder(int[] state, int n) {
    bRent(state, n);
    fRent(state, n);
    return (int) Arrays.stream(state).filter(i -> i > 0).count();
  }

  public static void fRent(int[] state, int n) {
    for (int i = 0; i < n - 1; i++) {
      if (state[i] == 2 && state[i + 1] == 0) {
        state[i]--;
        state[i + 1]++;
      }
    }
  }

  public static void bRent(int[] state, int n) {
    for (int i = 1; i < n; i++) {
      if (state[i] == 2 && state[i - 1] == 0) {
        state[i]--;
        state[i - 1]++;
      }
    }
  }


  public int solution999(int[] numbers, int target) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int num : numbers) {
      Stack<Integer> tmp = new Stack<>();
      while (!stack.isEmpty()) {
        int value = stack.pop();
        tmp.push(value + num);
        tmp.push(value - num);
      }
      stack.addAll(tmp);
    }
    return (int) stack.stream().filter(i -> i == target).count();
  }

  // 소수찾기
  public static int solution9999(int n) {
    boolean[] bools = new boolean[n + 1];
    bools[0] = true;
    bools[1] = true;
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j * i <= n && j <= i; j++) {
        bools[j * i] = true;
      }
    }

    int count = 0;
    for (int i = 0; i <= n; i++) {
      if (bools[i] == false) {
        count++;
      }
    }

    return count;
  }

  public static int[] solution00000(int[] arr) {
    List<Integer> list = new LinkedList<>();
    for (int i : arr) {
      list.add(i);
    }
    Arrays.sort(arr);
    list.remove(Integer.valueOf(arr[0]));
    if (list.size() == 0) {
      return new int[] {-1};
    }
    arr = list.stream().mapToInt(i -> i).toArray();
    return arr;
  }
}
