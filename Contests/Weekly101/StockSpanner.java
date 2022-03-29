import java.util.*;

public class StockSpanner {
  Stack<int[]> st;

  public StockSpanner() {
    st = new Stack<>();
  }

  public int next(int price) {
    int count = 1;
    while (!st.isEmpty() && st.peek()[0] <= price) {
      int[] curr = st.pop();
      count += curr[1];
    }
    st.push(new int[] { price, count });
    return st.peek()[1];
  }
}
