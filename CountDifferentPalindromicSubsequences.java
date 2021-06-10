public class CountDifferentPalindromicSubsequences {
  public int countPalindromicSubsequences(String S) {
    int[][] dp = new int[S.length()][S.length()];
    for (int g = 0; g < dp.length; g++) {
      for (int i = 0, j = g; j < dp.length; j++, i++) {
        if (g == 0) {
          dp[i][j] = 1;
        } else if (g == 1) {
          dp[i][j] = S.charAt(i) == S.charAt(j) ? 3 : 2;
        } else {
          if (S.charAt(i) == S.charAt(j)) {
            dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
          } else {
            dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
          }
        }
      }
    }
    return dp[0][dp.length - 1];
  }
}
