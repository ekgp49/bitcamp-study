import java.util.Deque;
import java.util.LinkedList;

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
    answer = d.stream().mapToInt(item -> item).toArray();
    return answer;
  }
}
