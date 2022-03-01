public class CountingBits {
  public boolean isPowerOfTwo(int x) {
    return x != 0 && ((x & (x - 1)) == 0);
  }

  public int[] countBits(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    int power = 1;
    for (int i = 1; i < dp.length; i++) {
      if (isPowerOfTwo(i)) {
        power = i;
      }
      dp[i] = 1 + dp[i - power];
    }
    return dp;

  }
}