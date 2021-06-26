import java.util.Stack;

public class StockSpanner {
  Stack<int[]> main;

  public StockSpanner() {
    main = new Stack<>();
  }

  public int next(int price) {
    int ans = 1;
    while (!main.isEmpty() && main.peek()[0] <= price) {
      ans += main.pop()[1];
    }
    main.push(new int[] { price, ans });
    return ans;
  }
}
