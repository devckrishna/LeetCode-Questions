public class SplitArrayLargestSum {
  public boolean solve(int[] nums, long mid, int m) {
    int count = 1;
    long sum = 0;
    for (int num : nums) {
      sum += num;
      if (sum > mid) {
        sum = num;
        count++;
      }
      if (count > m) {
        return false;
      }
    }
    return true;
  }

  public int splitArray(int[] nums, int m) {
    int mod = 1000000007;
    long start = 0;
    long end = 0;
    for (int num : nums) {
      end += num;
      start = Math.max(start, num);
    }
    while (start < end) {
      long mid = (start + end) / 2;
      if (solve(nums, mid, m)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return (int) end % mod;
  }
}
