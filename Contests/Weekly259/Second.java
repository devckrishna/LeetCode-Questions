public class Second {
  public int sumOfBeauties(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    left[0] = nums[0];
    for (int i = 1; i < left.length; i++) {
      left[i] = Math.max(nums[i], left[i - 1]);
    }
    right[right.length - 1] = nums[nums.length - 1];
    for (int i = right.length - 2; i >= 0; i--) {
      right[i] = Math.min(right[i + 1], nums[i]);
    }
    int ans = 0;
    for (int i = 1; i <= nums.length - 2; i++) {
      if (left[i] <= nums[i] && right[i] >= nums[i] && left[i] != left[i - 1] && right[i] != right[i + 1]) {
        ans += 2;
      } else if (nums[i - 1] < nums[i] && nums[i + 1] > nums[i]) {
        ans++;
      }
    }
    return ans;
  }
}
