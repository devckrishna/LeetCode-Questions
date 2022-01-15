import java.util.*;

public class JumpGameVI {
  public int maxResult(int[] nums, int k) {
    int[] dp = new int[nums.length];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    pq.add(new int[] { nums[nums.length - 1], nums.length - 1 });
    dp[dp.length - 1] = nums[nums.length - 1];
    for (int i = dp.length - 2; i >= 0; i--) {
      while (pq.peek()[1] > i + k) {
        pq.poll();
      }
      dp[i] = nums[i] + pq.peek()[0];
      pq.add(new int[] { dp[i], i });
    }

    return dp[0];
  }
}
