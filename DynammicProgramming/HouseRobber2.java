import java.util.HashMap;

public class HouseRobber2 {
  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(solve(nums, 0, nums.length - 2, new HashMap<>()), solve(nums, 1, nums.length - 1, new HashMap<>()));
  }

  public int solve(int[] nums, int low, int high, HashMap<Integer, Integer> map) {
    if (low > high) {
      return 0;
    }
    if (map.containsKey(low)) {
      return map.get(low);
    }
    int ans = Math.max(nums[low] + solve(nums, low + 2, high, map), solve(nums, low + 1, high, map));
    map.put(low, ans);
    return ans;
  }
}
