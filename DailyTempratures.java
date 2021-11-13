import java.util.Stack;

public class DailyTempratures {
  public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[temperatures.length];
    st.push(ans.length - 1);
    for (int i = ans.length - 2; i >= 0; i--) {
      while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
        st.pop();
      }
      if (st.isEmpty()) {
        ans[i] = 0;
      } else {
        ans[i] = st.peek() - i;
      }
      st.push(i);
    }

    return ans;
  }
}
