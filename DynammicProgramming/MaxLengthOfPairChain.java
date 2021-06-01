import java.util.Arrays;

public class MaxLengthOfPairChain {
  public int findLongestChain(int[][] pairs) {
    if (pairs.length == 1)
      return 1;
    Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    int dp[] = new int[pairs.length];
    dp[0] = 1;

    for (int i = 1; i < pairs.length; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (pairs[i][0] > pairs[j][1]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
          break;
        }
      }
    }

    return dp[pairs.length - 1];
  }
}
