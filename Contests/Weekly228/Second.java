public class Second {
  long mod = 1000000007;

  public int countHomogenous(String s) {
    int[] dp = new int[s.length()];
    dp[0] = 1;
    long ans = 1;
    for (int i = 1; i < s.length(); i++) {
      dp[i] = 1;
      if (s.charAt(i - 1) == s.charAt(i)) {
        dp[i] += dp[i - 1];
      }
      ans = (ans + dp[i]) % mod;
    }
    return (int) (ans % mod);
  }
}
