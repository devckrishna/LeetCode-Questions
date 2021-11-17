public class Third {
  public int solve(int[] nums, int[] muls, int i, int j, int index, Integer[][] dp) {
    if (index >= muls.length) {
      return 0;
    }
    if (dp[index][i] != null) {
      return dp[index][i];
    }
    int left = nums[i] * muls[index] + solve(nums, muls, i + 1, j, index + 1, dp);
    int right = nums[j] * muls[index] + solve(nums, muls, i, j - 1, index + 1, dp);

    return dp[index][i] = Math.max(left, right);
  }

  public int maximumScore(int[] nums, int[] multipliers) {
    return solve(nums, multipliers, 0, nums.length - 1, 0, new Integer[multipliers.length][multipliers.length]);
  }
}
