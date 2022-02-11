import java.util.*;

public class CountVowelPerutations {
  public int countVowelPermutation(int n) {
    int mod = 1000000007;
    long[][] dp = new long[n + 1][5];
    Arrays.fill(dp[1], 1);
    long ans = 5;
    for (int i = 2; i < dp.length; i++) {
      dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
      dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
      dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
      dp[i][3] = (dp[i - 1][2]) % mod;
      dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
      ans = (dp[i][0] + dp[i][1] + dp[i][2] + dp[i][3] + dp[i][4]) % mod;
    }
    return (int) ans;
  }
}
