import java.util.*;

public class LargestDivisibleSubset {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int[] dp = new int[nums.length];
    int[] pre = new int[nums.length];
    Arrays.sort(nums);
    int index = -2;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      pre[i] = -1;
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            pre[i] = j;
          }
        }
      }
      if (dp[i] > max) {
        max = dp[i];
        index = i;
      }
    }

    while (index != -1) {
      ans.add(nums[index]);
      index = pre[index];
    }
    return ans;
  }
}
