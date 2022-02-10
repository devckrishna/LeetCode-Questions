import java.util.Arrays;

public class MinFallingPathSum2 {
  public int minFallingPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid.length];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp.length; j++) {
        if (i == 0) {
          dp[i][j] = grid[i][j];
        } else {
          for (int k = 0; k < dp.length; k++) {
            if (k == j)
              continue;
            dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k]);
          }
        }
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < dp.length; i++) {
      ans = Math.min(dp[dp.length - 1][i], ans);
    }
    return ans;
  }
}
