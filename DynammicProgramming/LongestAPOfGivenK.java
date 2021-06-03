import java.util.*;

public class LongestAPOfGivenK {
  public int longestSubsequence(int[] a, int d) {
    Map<Integer, Integer> dp = new HashMap<>();
    for (int n : a) {
      dp.put(n, 1);
      if (dp.containsKey(n - d))
        dp.put(n, dp.get(n - d) + 1);
    }
    return Collections.max(dp.values());
  }
}
