public class SplitArrayLargeSum {
  public int splitArray(int[] nums, int m) {
    int start = 0;
    int end = 0;
    for (int curr : nums) {
      start = Math.max(start, curr);
      end += curr;
    }

    while (start < end) {
      int mid = (start + end) / 2;
      if (isValid(nums, mid, m)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }

  public boolean isValid(int[] arr, int target, int m) {
    int count = 1;
    int sum = 0;
    for (int curr : arr) {
      sum += curr;
      if (sum > target) {
        sum = curr;
        count++;
        if (count > m) {
          return false;
        }
      }
    }
    return true;
  }
}
