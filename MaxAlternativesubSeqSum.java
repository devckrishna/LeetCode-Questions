public class MaxAlternativesubSeqSum {
  public long maxAlternatingSum(int[] nums) {
    Long[][] dp = new Long[nums.length + 1][2];
    return solve(nums, 0, 0, dp);
  }

  public long solve(int[] nums, int index, int isOdd, Long[][] dp) {
    if (index == nums.length) {
      return 0;
    }
    if (dp[index][isOdd] != null) {
      return dp[index][isOdd];
    }
    long exclude = solve(nums, index + 1, isOdd, dp);
    long include = solve(nums, index + 1, isOdd == 0 ? 1 : 0, dp);
    if (isOdd == 0) {
      include += nums[index];
    } else {
      include -= nums[index];
    }
    dp[index][isOdd] = Math.max(include, exclude);
    return dp[index][isOdd];
  }
}
