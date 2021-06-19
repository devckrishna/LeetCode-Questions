public class KnightDailer {
  int mod = (int) Math.pow(10, 9) + 7;

  public int knightDialer(int n) {
    long sum = 0;
    Long[][][] dp = new Long[n + 1][4][3];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        sum = (sum + solve(dp, i, j, n)) % mod;
      }
    }

    return (int) sum;
  }

  public long solve(Long[][][] dp, int i, int j, int n) {
    if (i >= 4 || i < 0 || j < 0 || j >= 3 || (i == 3 && j != 1)) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (dp[n][i][j] != null) {
      return dp[n][i][j];
    }
    dp[n][i][j] = solve(dp, i - 1, j - 2, n - 1) % mod + solve(dp, i - 2, j - 1, n - 1) % mod
        + solve(dp, i - 2, j + 1, n - 1) % mod + solve(dp, i - 1, j + 2, n - 1) % mod
        + solve(dp, i + 1, j + 2, n - 1) % mod + solve(dp, i + 2, j + 1, n - 1) % mod
        + solve(dp, i + 2, j - 1, n - 1) % mod + solve(dp, i + 1, j - 2, n - 1) % mod;

    return dp[n][i][j];
  }
}
