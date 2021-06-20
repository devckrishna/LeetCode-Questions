import java.util.*;

public class ArithematicSubArrays {
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    List<Boolean> ans = new ArrayList<>();
    for (int i = 0; i < l.length; i++) {
      ans.add(solve(nums, l[i], r[i]));
    }
    return ans;
  }

  private boolean solve(int[] nums, int l, int r) {
    if (r - l <= 1) {
      return true;
    }
    Set<Integer> set = new HashSet<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = l; i <= r; i++) {
      set.add(nums[i]);
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    if (min == max)
      return true;
    if ((max - min) % (r - l) != 0) {
      return false;
    }
    int d = (max - min) / (r - l);
    for (int i = min; i <= max; i += d) {
      if (!set.contains(i)) {
        return false;
      }
    }
    return true;
  }
}
