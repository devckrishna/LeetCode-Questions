public class TwoKeyBoard {
  public int minSteps(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 0;
    dp[2] = 2;
    for (int i = 3; i < dp.length; i++) {
      dp[i] = i;
      int j = i / 2;
      while (j >= 1) {
        if (i % j == 0) {
          dp[i] = Math.min(dp[i], dp[j] + i / j);
        }
        j--;
      }
    }
    return dp[n + 1];
  }
}
