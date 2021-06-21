public class MaxConsecutitveOnes3 {
  public int longestOnes(int[] nums, int k) {
    int count = 0;
    int start = 0;
    int ans = 0;
    for (int end = 0; end < nums.length; end++) {
      if (nums[end] == 0) {
        count++;
      }
      while (count > k) {
        if (nums[start] == 0) {
          count--;
        }
        start++;
      }

      ans = Math.max(end - start + 1, ans);
    }
    return ans;
  }
}