public class KnightDailer {
  public static final int mod = (int) Math.pow(10, 9) + 7;

  public int knightDialer(int n) {
    Long[][][] dp = new Long[n + 1][4][3];
    long ans = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        ans = (ans + solve(dp, i, j, n)) % mod;
      }
    }
    return (int) ans;
  }

  public long solve(Long[][][] dp, int i, int j, int n) {
    if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (dp[n][i][j] != null) {
      return dp[n][i][j];
    }
    long ans = solve(dp, i - 1, j - 2, n - 1) % mod + solve(dp, i - 2, j - 1, n - 1) % mod
        + solve(dp, i - 2, j + 1, n - 1) % mod + solve(dp, i - 1, j + 2, n - 1) % mod
        + solve(dp, i + 1, j + 2, n - 1) % mod + solve(dp, i + 2, j + 1, n - 1) % mod
        + solve(dp, i + 2, j - 1, n - 1) % mod + solve(dp, i + 1, j - 2, n - 1) % mod;
    dp[n][i][j] = ans;
    return ans;
  }
}
