import java.util.*;

public class LongestArithematicSubsequence {
  public int longestArithSeqLength(int[] nums) {
    HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
    int ans = 2;
    for (int i = 0; i < nums.length; i++) {
      dp[i] = new HashMap<>();
      for (int j = 0; j < i; j++) {
        int d = nums[i] - nums[j];
        dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
        ans = Math.max(ans, dp[i].get(d));
      }
    }

    return ans;
  }
}
