public class Fourth {
  public int waysToPartition(int[] nums, int k) {
    int ans = 0;
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      nums[i] = k;
      int curr = solve(nums, 0, nums.length - 1, sum);
      ans = Math.max(ans, curr);
      nums[i] = temp;
    }
    return ans;
  }

  public int solve(int[] a, int startPos, int endPos, long totalSum) {
    long leftSum = 0;
    long rightSum = totalSum;
    for (int splitPos = startPos; splitPos < endPos; splitPos++) {
      leftSum += a[splitPos];
      rightSum -= a[splitPos];
      if (leftSum > rightSum)
        break;
      if (leftSum == rightSum) {
        int leftScore = solve(a, startPos, splitPos, leftSum);
        int rightScore = solve(a, splitPos + 1, endPos, rightSum);
        return 1 + Math.max(leftScore, rightScore);
      }
    }
    return 0;
  }
}
