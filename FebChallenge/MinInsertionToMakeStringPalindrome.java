public class MinInsertionToMakeStringPalindrome {
  public int minInsertions(String s) {
    int ans = 0;
    int[][] dp = new int[s.length()][s.length()];
    for (int g = 0; g < dp.length; g++) {
      for (int i = 0, j = g; j < dp.length; i++, j++) {
        if (g == 0) {
          dp[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return s.length() - ans;
  }
}
