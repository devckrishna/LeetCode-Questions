import java.util.Arrays;

public class CombinationSum4 {
  static int[] dp;

  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    dp = new int[target + 1];
    Arrays.fill(dp, -1);
    return solve(nums, target);
  }

  public int solve(int[] nums, int target) {
    if (target == 0) {
      return 1;
    }
    if (dp[target] != -1) {
      return dp[target];
    }
    int count = 0;
    for (int curr : nums) {
      if (target - curr < 0) {
        break;
      }
      count += solve(nums, target - curr);
    }
    dp[target] = count;
    return count;
  }
}
