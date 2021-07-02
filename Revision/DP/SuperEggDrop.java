public class SuperEggDrop {
  public int superEggDrop(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    for (int egg = 1; egg <= n; egg++) {
      for (int floor = 1; floor <= k; floor++) {
        if (egg == 1) {
          dp[egg][floor] = floor;
        } else if (floor == 1) {
          dp[egg][floor] = 1;
        } else {
          int min = Integer.MAX_VALUE;
          for (int first = floor - 1, second = 0; first >= 0; first--, second++) {
            int survives = dp[egg][first];
            int breaks = dp[egg - 1][second];
            min = Math.min(min, Math.max(survives, breaks));
          }
          dp[egg][floor] = min + 1;
        }
      }
    }
    return dp[n][k];
  }
}
