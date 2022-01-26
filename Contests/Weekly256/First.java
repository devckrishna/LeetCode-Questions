import java.util.*;

public class First {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int start = nums.length - k;
    int end = nums.length - 1;
    int ans = Integer.MAX_VALUE;
    while (start >= 0 && end >= 0) {
      ans = Math.min(ans, nums[end] - nums[start]);
      start--;
      end--;
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}