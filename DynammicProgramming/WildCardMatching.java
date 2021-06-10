public class WildCardMatching {
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
    dp[0][0] = true;
    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = p.charAt(i - 1) == '*' || dp[i - 1][0];
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (p.charAt(i - 1) == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else if (p.charAt(i - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = p.charAt(i - 1) == s.charAt(j - 1) && dp[i - 1][j - 1];
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }
}
