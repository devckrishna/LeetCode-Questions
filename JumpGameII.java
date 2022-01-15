public class JumpGameII {
  public int jump(int[] nums) {
    Integer[] dp = new Integer[nums.length];
    dp[dp.length - 1] = 0;
    for (int i = dp.length - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
        if (dp[i + j] != null) {
          min = Math.min(min, dp[i + j] + j);
        }
      }
      if (min != Integer.MAX_VALUE)
        dp[i] = min;
    }
    return dp[0];
  }
}
