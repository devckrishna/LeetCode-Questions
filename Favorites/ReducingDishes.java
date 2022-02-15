import java.util.Arrays;

public class ReducingDishes {
  public int maxSatisfaction(int[] satisfaction) {
    Arrays.sort(satisfaction);
    Integer[][] dp = new Integer[satisfaction.length + 1][satisfaction.length + 1];
    return solve(satisfaction, 0, 1, dp);
  }

  public int solve(int[] arr, int index, int time, Integer[][] dp) {
    if (index == arr.length) {
      return 0;
    }
    if (dp[index][time] != null) {
      return dp[index][time];
    }
    int first = arr[index] * time + solve(arr, index + 1, time + 1, dp);
    int second = solve(arr, index + 1, time, dp);
    dp[index][time] = Math.max(first, second);
    return dp[index][time];
  }
}