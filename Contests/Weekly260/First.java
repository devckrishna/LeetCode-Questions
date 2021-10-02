public class First {
  public int maximumDifference(int[] nums) {
    int n = nums.length;
    int ans = -1;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[j] > nums[i])
          ans = Math.max(ans, nums[j] - nums[i]);
      }
    }
    return ans;
  }
}