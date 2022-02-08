import java.util.*;

public class AllocateMailboxes {
  public int minDistance(int[] houses, int k) {
    Arrays.sort(houses);
    Integer[][] dp = new Integer[101][101];
    int[][] cost = new int[101][101];
    for (int i = 0; i < houses.length; i++) {
      for (int j = 0; j < houses.length; j++) {
        int median = (i + j) / 2;
        for (int x = i; x <= j; x++) {
          cost[i][j] += Math.abs(houses[median] - houses[x]);
        }
      }
    }
    return solve(houses, 0, cost, dp, k);
  }

  public int solve(int[] arr, int index, int[][] cost, Integer[][] dp, int k) {
    if (k == 0 && index == arr.length) {
      return 0;
    }
    if (k == 0 || index == arr.length) {
      return 1000000;
    }
    if (dp[index][k] != null) {
      return dp[index][k];
    }
    int ans = 1000000;
    for (int i = index; i < arr.length; i++) {
      ans = Math.min(ans, cost[index][i] + solve(arr, i + 1, cost, dp, k - 1));
    }
    dp[index][k] = ans;
    return ans;
  }
}
