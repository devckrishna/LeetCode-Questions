public class Fourth {
  public int longestPalindrome(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    int[][] dp = solve(word1 + word2);
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (word1.charAt(i) == word2.charAt(j)) {
          ans = Math.max(ans, 2 + dp[i + 1][n + j - 1]);
        }
      }
    }

    return ans;
  }

  public int[][] solve(String s) {
    int[][] dp = new int[s.length()][s.length()];
    for (int g = 0; g < s.length(); g++) {
      for (int i = 0, j = g; j < s.length(); i++, j++) {
        if (g == 0) {
          dp[i][j] = 1;
        } else if (g == 1) {
          dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dp[i + 1][j - 1] + 2;
          } else {
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
          }
        }
      }
    }

    return dp;
  }
}
