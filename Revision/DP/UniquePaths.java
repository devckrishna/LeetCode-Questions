public class UniquePaths {
  public int uniquePaths(int m, int n) {
    Integer[][] dp = new Integer[n][m];
    return solve(n, m, 0, 0, dp);
  }

  public int solve(int m, int n, int i, int j, Integer[][] dp) {
    if (i < 0 || j < 0 || i >= m || j >= n) {
      return 0;
    }
    if (dp[i][j] != null) {
      return dp[i][j];
    }
    if (i == m - 1 && j == n - 1) {
      return 1;
    }
    int ans = 0;
    ans += solve(m, n, i + 1, j, dp);
    ans += solve(m, n, i, j + 1, dp);
    dp[i][j] = ans;
    return ans;
  }
}
