public class MinWindowSubsequence {
  public String minWindow(String s1, String s2) {
    int[][] dp = new int[s2.length() + 1][s1.length() + 1];
    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = i + 1;
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (s1.charAt(j - 1) == s2.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    int start = 0;
    int len = s1.length() + 1;
    for (int i = 1; i < dp[0].length; i++) {
      if (dp[dp.length - 1][i] != 0) {
        if (i - dp[dp.length - 1][i] + 1 < len) {
          start = dp[dp.length - 1][i] - 1;
          len = i - dp[dp.length - 1][i] + 1;
        }
      }
    }
    return len == s1.length() + 1 ? "" : s1.substring(start, start + len);
  }
}
