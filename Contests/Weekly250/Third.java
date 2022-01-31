public class Third {
  public long maxPoints(int[][] points) {
    long[] dp = new long[points[0].length];
    for (int[] point : points) {
      for (int i = 0; i < dp.length; i++) {
        dp[i] += point[i];
      }
      for (int i = 1; i < dp.length; i++) {
        dp[i] = Math.max(dp[i], dp[i - 1] - 1);
      }
      for (int i = dp.length - 2; i >= 0; i--) {
        dp[i] = Math.max(dp[i], dp[i + 1] - 1);
      }
    }
    long ans = 0;
    for (long curr : dp) {
      ans = Math.max(ans, curr);
    }
    return ans;
  }
}
