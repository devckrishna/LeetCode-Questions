public class Third {
  public int minimumSize(int[] nums, int maxOperations) {
    int start = 0;
    int end = 1_000_000_000;
    while (start < end) {
      int mid = start + (end - start) / 2;
      int count = 0;
      for (int i : nums) {
        count += (i - 2) / mid;
      }
      if (count > maxOperations) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }
}
