import java.util.Arrays;

public class AddSubtractTargetSum {
  public int findTargetSumWays(int[] nums, int target) {
    int[][] dp = new int[nums.length][2001];
    for (int[] arr : dp) {
      Arrays.fill(arr, Integer.MIN_VALUE);
    }
    return solve(nums, 0, 0, target, dp);
  }

  public static int solve(int[] nums, int index, int sum, int target, int[][] dp) {
    if (index == nums.length) {
      if (sum == target) {
        return 1;
      } else {
        return 0;
      }
    }

    if (dp[index][sum + 1000] != Integer.MIN_VALUE) {
      return dp[index][sum + 1000];
    }
    int add = solve(nums, index + 1, sum + nums[index], target, dp);
    int subtract = solve(nums, index + 1, sum - nums[index], target, dp);
    dp[index][sum + 1000] = add + subtract;
    return dp[index][sum + 1000];

  }
}
