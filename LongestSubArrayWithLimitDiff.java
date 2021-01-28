import java.util.*;

class LongestSubArrayWithLimitDiff {
  public int longestSubarray(int[] nums, int limit) {
    TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
    int ans = 1;
    set.add(0);
    int left = 0;
    for (int right = 1; right < nums.length; right++) {
      set.add(right);
      while (nums[set.last()] - nums[set.first()] > limit) {
        set.remove(left++);
      }
      ans = Math.max(ans, right - left + 1);
    }

    return ans;
  }
}