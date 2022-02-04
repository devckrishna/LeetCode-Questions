import java.util.*;

public class BinaryTreeWithFactors {
  public int numFactoredBinaryTrees(int[] arr) {
    int mod = 1000000007;
    Arrays.sort(arr);
    long[] dp = new long[arr.length];
    Arrays.fill(dp, 1);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++)
      map.put(arr[i], i);

    for (int i = 0; i < arr.length; ++i)
      for (int j = 0; j < i; ++j) {
        if (arr[i] % arr[j] == 0) {
          int right = arr[i] / arr[j];
          if (map.containsKey(right)) {
            dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % mod;
          }
        }
      }

    long ans = 0;
    for (long num : dp)
      ans += num;
    return (int) (ans % mod);
  }
}
