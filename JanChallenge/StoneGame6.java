public class StoneGame6 {
  public boolean solve(int n, Boolean[] dp) {
    if (n <= 0) {
      return false;
    }
    if (dp[n] != null) {
      return dp[n];
    }
    for (int i = 1; i * i <= n; i++) {
      if (!solve(n - i * i, dp)) {
        dp[n] = true;
        return true;
      }
    }
    dp[n] = false;
    return false;
  }

  public boolean winnerSquareGame(int n) {
    Boolean[] dp = new Boolean[n + 1];
    return solve(n, dp);
  }
}
