public class NumberOfWaysofPaintingnx3grid {
  int mod = 1000000007;

  public int numOfWays(int n) {
    Integer[][][][] dp = new Integer[n][4][4][4];
    return solve(0, 0, 0, 0, n, dp);
  }

  public int solve(int index, int first, int second, int third, int n, Integer[][][][] dp) {
    if (index == n) {
      return 1;
    }
    if (dp[index][first][second][third] != null) {
      return dp[index][first][second][third];
    }
    int ans = 0;
    for (int i = 1; i <= 3; i++) {
      if (i != first)
        for (int j = 1; j <= 3; j++) {
          if (j != second && i != j)
            for (int k = 1; k <= 3; k++) {
              if (k != third && j != k)
                ans = (ans + solve(index + 1, i, j, k, n, dp)) % mod;
            }
        }
    }
    dp[index][first][second][third] = ans;
    return ans;
  }
}
