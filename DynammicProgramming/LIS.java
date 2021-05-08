public class LIS {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int ans = 0;
    for (int i = 0; i < dp.length; i++) {
      int currMax = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          currMax = Math.max(currMax, dp[j]);
        }
      }
      dp[i] = currMax + 1;
      ans = Math.max(ans, dp[i]);
    }

    return ans;
  }
}
