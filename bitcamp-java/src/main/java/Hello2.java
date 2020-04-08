import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Hello2 {
  public static void main(String[] args) {
    System.out.println(solution()[4]);
    System.out.println(solution2()[4]);
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
  public int solution(int n, int[] lost, int[] reserve) {

    List<String> lostList = new ArrayList<>();
    List<String> have2 = new ArrayList<>();

    // 번호를 문자열로 바꾼다.
    for (int i = 0; i < lost.length; i++) {
      lostList.add(String.valueOf(lost[i]));
    }

    for (int i = 0; i < reserve.length; i++) {
      have2.add(String.valueOf(reserve[i]));
    }

    // 두개있는데 하나 잃어버린애들
    for (int i = 0; i < lost.length; i++) {
      String lostNo = String.valueOf(lost[i]);
      if (have2.contains(lostNo)) {
        have2.remove(lostNo); // 이제 하나가짐
        lostList.remove(lostNo); // 적어도 한개 가졌으니 제외함
      }
    }

    // lostList엔 이제 0개인 애들만 있음
    // 번호 +-1인 애가 2개 있으면 하나 받아먹음
    int count = 0; // 받아먹는 놈들 있으면 카운트
    for (int i = 0; i < lostList.size(); i++) {
      int lostNo = Integer.parseInt(lostList.get(i));
      String formerNo = String.valueOf(lostNo - 1);
      String nextNo = String.valueOf(lostNo + 1);
      if (have2.contains(formerNo)) {
        have2.remove(formerNo);
        count++;
      } else if (have2.contains(nextNo)) {
        have2.remove(nextNo);
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

}
