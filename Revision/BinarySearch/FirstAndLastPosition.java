public class FirstAndLastPosition {
  public int[] searchRange(int[] nums, int target) {
    int first = binarySearch(nums, target);
    if (first == nums.length || nums[first] != target) {
      return new int[] { -1, -1 };
    }
    int second = binarySearch(nums, target + 1);
    return new int[] { first, nums[second] == target ? second : second - 1 };
  }

  public int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }
}
