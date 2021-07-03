public class CountPalSubstr {
  int mod = 1000000007;

  public int countPalindromicSubsequences(String s) {
    long[][] dp = new long[s.length()][s.length()];
    for (int g = 0; g < s.length(); g++) {
      for (int i = 0, j = g; j < s.length(); i++, j++) {
        if (g == 0) {
          dp[i][j] = 1;
        } else if (g == 1) {
          dp[i][j] = s.charAt(i) == s.charAt(j) ? 3 : 2;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = (dp[i][j - 1] % mod + dp[i + 1][j] % mod + 1) % mod;
          } else {
            dp[i][j] = (dp[i][j - 1] % mod + dp[i + 1][j] % mod - dp[i + 1][j - 1] % mod) % mod;
          }
        }
      }
    }
    return (int) dp[0][s.length() - 1];
  }
}
