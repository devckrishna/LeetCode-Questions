public class CapacityToShipPackages {
  public boolean solve(int[] arr, int mid, int days) {
    int count = 1;
    int sum = 0;
    for (int w : arr) {
      sum += w;
      if (sum > mid) {
        sum = w;
        count++;
      }
      if (count > days) {
        return false;
      }
    }
    return true;
  }

  public int shipWithinDays(int[] weights, int days) {
    int start = 0;
    int end = 0;
    for (int i = 0; i < weights.length; i++) {
      start = Math.max(start, weights[i]);
      end += weights[i];
    }
    while (start < end) {
      int mid = (start + end) / 2;
      if (solve(weights, mid, days)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return start;
  }
}