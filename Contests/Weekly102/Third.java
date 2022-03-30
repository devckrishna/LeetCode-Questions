import java.util.Stack;

public class Third {

  public int sumSubarrayMins(int[] arr) {
    int ans = 0;
    int mod = 1000000007;
    int[] dp = new int[arr.length + 1];
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    for (int i = 0; i < arr.length; i++) {
      while (st.peek() != -1 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }
      dp[i + 1] = dp[st.peek() + 1] + (i - st.peek()) * arr[i];
      ans = (ans + dp[i + 1]) % mod;
      st.push(i);
    }
    return ans;
  }
}
