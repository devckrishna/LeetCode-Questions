public class PalindromicSubstrings {
  public int countSubstrings(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int ans = 0;
    for (int g = 0; g < dp.length; g++) {
      for (int i = 0, j = g; j < dp.length; i++, j++) {
        if (g == 0) {
          dp[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          if (s.charAt(i) == s.charAt(j))
            dp[i][j] = dp[i + 1][j - 1];
        }
        ans += dp[i][j] ? 1 : 0;
      }
    }

    return ans;
  }
}
