public class Third {
  public int minimumDeletions(int[] nums) {
    int minIndex = -1;
    int maxIndex = -1;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= min) {
        min = nums[i];
        minIndex = i;
      }
      if (nums[i] >= max) {
        max = nums[i];
        maxIndex = i;
      }
    }

    if (minIndex == maxIndex) {
      return Math.min(minIndex + 1, nums.length - minIndex);
    }
    if (minIndex > maxIndex) {
      int temp = minIndex;
      minIndex = maxIndex;
      maxIndex = temp;
    }
    return Math.min(maxIndex + 1, Math.min(minIndex + 1 + nums.length - maxIndex, nums.length - minIndex));
  }
}
