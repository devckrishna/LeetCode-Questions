public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    if (sum % 2 != 0) {
      return false;
    }
    int[][] dp = new int[nums.length][sum];
    return solve(nums, sum / 2, dp, 0, 0);
  }

  public boolean solve(int[] nums, int target, int[][] dp, int index, int sum) {
    if (index == nums.length) {
      if (target == 0) {
        return true;
      } else {
        return false;
      }
    }
    if (dp[index][sum] == 1) {
      return true;
    } else if (dp[index][sum] == 2) {
      return false;
    }
    if (target == 0) {
      return true;
    }
    boolean include = solve(nums, target - nums[index], dp, index + 1, sum + nums[index]);
    boolean exclude = solve(nums, target, dp, index + 1, sum);

    dp[index][sum] = (include || exclude) ? 1 : 2;
    return include || exclude;
  }
}
