public class DistinctSubsequence {
  public int numDistinct(String s, String t) {
    // int[][] dp = new int[s.length()][t.length()];
    // for (int i = 0; i < dp.length; i++) {
    // for (int j = 0; j < dp[0].length; j++) {
    // dp[i][j] = -1;
    // }
    // }
    // return solveMemo(s, t, 0, 0, dp);

    return solveT(s, t);
  }

  // TABULATION
  public int solveT(String s, String t) {
    int[][] dp = new int[t.length() + 1][s.length() + 1];
    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = dp[0].length - 1; j >= 0; j--) {
        if (i == dp.length - 1) {
          dp[i][j] = 1;
        } else if (j == dp[0].length - 1) {
          dp[i][j] = 0;
        } else {
          char c1 = t.charAt(i);
          char c2 = s.charAt(j);
          if (c1 != c2) {
            dp[i][j] = dp[i][j + 1];
          } else {
            dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
          }
        }
      }
    }
    return dp[0][0];
  }

  // MEMOIZATION
  public int solveMemo(String s, String t, int si, int ti, int[][] dp) {
    if (si == s.length()) {
      if (ti == t.length()) {
        return 1;
      } else {
        return 0;
      }
    } else if (ti == t.length()) {
      return 1;
    }

    char c1 = s.charAt(si);
    char c2 = t.charAt(ti);
    if (dp[si][ti] != -1) {
      return dp[si][ti];
    }

    int ans = 0;
    if (c1 != c2) {
      ans = solveMemo(s, t, si + 1, ti, dp);
    } else {
      int t1 = solveMemo(s, t, si + 1, ti + 1, dp);
      int t2 = solveMemo(s, t, si + 1, ti, dp);
      ans = t1 + t2;
    }
    dp[si][ti] = ans;
    return ans;
  }
}
