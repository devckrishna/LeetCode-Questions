class MaxSubArraySum {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int maxEnd = 0;
    for (int i = 0; i < nums.length; i++) {
      maxEnd = maxEnd + nums[i];
      if (maxSum < maxEnd) {
        maxSum = maxEnd;
      }
      if (maxEnd < 0) {
        maxEnd = 0;
      }
    }
    return maxSum;
  }
}