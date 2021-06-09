public class MaxProductSubArray {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = nums[0];
    int min = nums[0];
    int ans = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int temp = max;
      max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
      min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
      if (max > ans) {
        ans = max;
      }
    }

    return ans;
  }
}
