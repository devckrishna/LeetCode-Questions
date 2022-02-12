import java.util.*;

public class Third {
  public int maxSumMinProduct(int[] nums) {
    int mod = 1000000007;
    Stack<Integer> st = new Stack<>();
    long[] prefixSum = new long[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    long ans = 0;
    for (int i = 0; i < prefixSum.length; i++) {
      while (!st.isEmpty() && (i == nums.length || nums[st.peek()] > nums[i])) {
        int curr = st.pop();
        ans = Math.max(ans, (prefixSum[i] - prefixSum[st.isEmpty() ? 0 : st.peek() + 1]) * nums[curr]);
      }
      st.push(i);
    }
    return (int) (ans % mod);
  }
}
