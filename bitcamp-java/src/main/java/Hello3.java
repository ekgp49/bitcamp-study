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
    return answer;
  }
}
