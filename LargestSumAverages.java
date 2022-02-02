public class LargestSumAverages {
  public double largestSumOfAverages(int[] nums, int k) {
    Double[][] dp = new Double[nums.length + 1][k + 1];
    double sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      dp[i + 1][1] = (sum) / (i + 1);
    }
    return solve(nums, nums.length, k, dp);
  }

  public double solve(int[] nums, int n, int k, Double[][] dp) {
    if (k == 0 || k > n) {
      return 0;
    }
    if (dp[n][k] != null) {
      return dp[n][k];
    }
    double ans = 0;
    double sum = 0;
    for (int i = n - 1; i > 0; i--) {
      sum += nums[i];
      ans = Math.max(ans, solve(nums, i, k - 1, dp) + sum / (n - i));
    }
    dp[n][k] = ans;
    return ans;
  }
}
