public class ValidPermutationsOfDISequence {
  public int numPermsDISequence(String S) {
    int n = S.length();
    int mod = (int) 1e9 + 7;
    int[][] dp = new int[n + 1][n + 1];
    for (int j = 0; j <= n; j++)
      dp[0][j] = 1;
    for (int i = 0; i < n; i++) {
      if (S.charAt(i) == 'I') {
        for (int j = 0, curr = 0; j < n - i; j++) {
          dp[i + 1][j] = curr = (curr + dp[i][j]) % mod;
        }
      } else {
        for (int j = n - i - 1, curr = 0; j >= 0; j--) {
          dp[i + 1][j] = curr = (curr + dp[i][j + 1]) % mod;
        }
      }
    }
    return dp[n][0];
  }
}
