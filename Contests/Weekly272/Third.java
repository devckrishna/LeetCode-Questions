import java.util.Arrays;

public class Third {
  public long getDescentPeriods(int[] prices) {
    int[] dp = new int[prices.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < dp.length; i++) {
      if (prices[i - 1] - prices[i] == 1) {
        dp[i] += dp[i - 1];
      }
    }
    long ans = 0;
    for (int curr : dp) {
      ans += curr;
    }
    return ans;
  }
}
