public class SearchInRotatedArray {
  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[start] <= nums[mid]) {
        if (nums[mid] > target && nums[start] <= target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (nums[mid] < target && nums[end] >= target) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return nums[start] == target ? start : -1;
  }
}
