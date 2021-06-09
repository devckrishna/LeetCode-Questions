import java.util.*;

class DailyTemprature {
  public int[] dailyTemperatures(int[] T) {
    int[] ans = new int[T.length];
    Stack<Integer> st = new Stack<>();
    for (int i = T.length - 1; i >= 0; i--) {
      int currTemp = T[i];
      while (!st.isEmpty() && currTemp >= T[st.peek()]) {
        st.pop();
      }
      ans[i] = st.isEmpty() ? 0 : st.peek() - i;
      st.push(i);
    }
    return ans;
  }
}