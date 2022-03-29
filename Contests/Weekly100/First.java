public class First {
  public boolean isMonotonic(int[] nums) {
    Boolean forward = true;
    Boolean reverse = true;
    int max = Integer.MIN_VALUE;
    for (int curr : nums) {
      if (max > curr) {
        forward = false;
        break;
      }
      max = Math.max(max, curr);
    }
    max = Integer.MAX_VALUE;
    for (int curr : nums) {
      if (max < curr) {
        reverse = false;
        break;
      }
      max = Math.min(max, curr);
    }

    return forward || reverse;
  }
}