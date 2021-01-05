class JumpGame {
  public boolean canJump(int[] nums) {
    Integer[] dp = new Integer[nums.length];
    dp[dp.length - 1] = 0;

    for (int i = dp.length - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      int steps = nums[i];
      for (int j = 1; j <= steps && i + j < nums.length; j++) {
        if (dp[i + j] != null && dp[i + j] < min) {
          min = dp[i + j];
        }
      }
      if (min != Integer.MAX_VALUE) {
        dp[i] = min + 1;
      }
    }
    return dp[0] != null;
  }
}