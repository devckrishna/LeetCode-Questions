public class CountSunmatricesWithAllOnes {
  public int countSquares(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];

    int ans = 0;
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
        } else {
          if (matrix[i][j] == 1)
            dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
        }
        ans += dp[i][j];
      }

    }
    return ans;
  }
}