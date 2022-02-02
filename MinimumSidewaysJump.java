public class MinimumSidewaysJump {
  public int minSideJumps(int[] obstacles) {
    int[][] dp = new int[obstacles.length][3];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[0][2] = 1;
    for (int i = 1; i < dp.length; i++) {
      if (obstacles[i] == 0) {
        dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1] + 1, dp[i - 1][2] + 1));
        dp[i][1] = Math.min(dp[i - 1][0] + 1, Math.min(dp[i - 1][1], dp[i - 1][2] + 1));
        dp[i][2] = Math.min(dp[i - 1][0] + 1, Math.min(dp[i - 1][1] + 1, dp[i - 1][2]));
      } else if (obstacles[i] == 1) {
        dp[i][0] = Integer.MAX_VALUE;
        dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2] + 1);
        dp[i][2] = Math.min(dp[i - 1][1] + 1, dp[i - 1][2]);
      } else if (obstacles[i] == 2) {
        dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][2] + 1);
        dp[i][1] = Integer.MAX_VALUE;
        dp[i][2] = Math.min(dp[i - 1][0] + 1, dp[i - 1][2]);
      } else {
        dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
        dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1]);
        dp[i][2] = Integer.MAX_VALUE;
      }

    }
    return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
  }
}
