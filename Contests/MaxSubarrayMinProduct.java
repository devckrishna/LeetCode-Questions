import java.util.*;

public class MaxSubarrayMinProduct {
  public int maxSumMinProduct(int[] nums) {
    Stack<Integer> st = new Stack<>();
    long[] dp = new long[nums.length + 1];
    long ans = 0;
    for (int i = 0; i < nums.length; i++) {
      dp[i + 1] = dp[i] + nums[i];
    }
    for (int i = 0; i <= nums.length; i++) {
      while (!st.isEmpty() && (i == nums.length || nums[st.peek()] > nums[i])) {
        int j = st.pop();
        ans = Math.max(ans, nums[j] * (dp[i] - dp[st.isEmpty() ? 0 : st.peek() + 1]));
      }

      st.push(i);
    }
    return (int) (ans % 1000000007);
  }
}
