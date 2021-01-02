import java.util.*;

class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return null;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int curr = target - nums[i];
      if (map.containsKey(curr))
        return new int[] { i, map.get(curr) };
      map.put(nums[i], i);
    }
    return null;
  }
}