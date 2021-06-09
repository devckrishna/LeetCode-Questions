import java.util.*;

public class DistinctSubsequences2 {
  public int distinctSubseqII(String S) {
    long[] dp = new long[S.length() + 1];
    dp[0] = 1;

    HashMap<Character, Integer> lo = new HashMap<>();

    for (int i = 1; i < dp.length; i++) {
      dp[i] = (2 * dp[i - 1]) % 1000000007;
      char ch = S.charAt(i - 1);
      if (lo.containsKey(ch)) {
        int j = lo.get(ch);
        dp[i] -= dp[j - 1] % 1000000007;
      }
      lo.put(ch, i);
      dp[i] = dp[i] % 1000000007;
    }
    return (int) (dp[S.length()] - 1) % 1000000007;
  }
}
