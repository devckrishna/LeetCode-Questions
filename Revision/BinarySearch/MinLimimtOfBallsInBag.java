public class MinLimimtOfBallsInBag {
  public int minimumSize(int[] nums, int maxOperations) {
    int start = 1;
    int end = 1000000000;
    while (start < end) {
      int mid = start + (end - start) / 2;
      int count = 0;
      for (int curr : nums) {
        count += (curr - 1) / mid;
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
