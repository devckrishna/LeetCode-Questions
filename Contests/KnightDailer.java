public class KnightDailer {
  int mod = (int) Math.pow(10, 9) + 7;

  public int knightDialer(int n) {
    long ans = 0;
    Long[][][] dp = new Long[n + 1][4][3];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        ans = (ans + solve(i, j, n, dp)) % mod;
      }
    }
    return (int) ans;
  }

  public long solve(int i, int j, int n, Long[][][] dp) {
    if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (dp[n][i][j] != null) {
      return dp[n][i][j];
    }
    long ans = 0;
    ans = (ans + solve(i - 2, j - 1, n - 1, dp)) % mod;
    ans = (ans + solve(i - 2, j + 1, n - 1, dp)) % mod;
    ans = (ans + solve(i - 1, j + 2, n - 1, dp)) % mod;
    ans = (ans + solve(i + 1, j + 2, n - 1, dp)) % mod;
    ans = (ans + solve(i + 2, j + 1, n - 1, dp)) % mod;
    ans = (ans + solve(i + 2, j - 1, n - 1, dp)) % mod;
    ans = (ans + solve(i + 1, j - 2, n - 1, dp)) % mod;
    ans = (ans + solve(i - 1, j - 2, n - 1, dp)) % mod;
    dp[n][i][j] = ans;
    return ans;
  }
}
