public class UnCrossedLines {
  public int maxUncrossedLines(int[] a, int[] b) {
    int[][] dp = new int[a.length + 1][b.length + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (a[i - 1] == b[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }
}
