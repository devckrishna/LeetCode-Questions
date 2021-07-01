public class LIS {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int ans = 0;
    for (int i = 0; i < dp.length; i++) {
      int count = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          count = Math.max(count, dp[j]);
        }
      }
      dp[i] = count + 1;
      ans = Math.max(ans, dp[i]);
    }

    return ans;
  }
}
