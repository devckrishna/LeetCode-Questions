public class Third {
  public int maximumTop(int[] nums, int k) {
    if (nums.length == 1) {
      return k % 2 == 1 ? -1 : nums[0];
    }
    int first = k >= nums.length ? -1 : nums[k];
    int second = -1;
    for (int i = 0; i < Math.min(k - 1, nums.length); i++) {
      second = Math.max(second, nums[i]);
    }
    return Math.max(first, second);
  }
}
