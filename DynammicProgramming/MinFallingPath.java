public class MinFallingPath {
  public int minFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = dp[0].length - 1; j >= 0; j--) {
        if (i == dp.length - 1) {
          dp[i][j] = matrix[i][j];
        } else if (j == 0) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        } else if (j == dp[0].length - 1) {
          dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
        } else {
          dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
        }
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < dp[0].length; i++) {
      ans = Math.min(ans, dp[0][i]);
    }
    return ans;
  }
}