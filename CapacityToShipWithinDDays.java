public class CapacityToShipWithinDDays {
  public int shipWithinDays(int[] weights, int days) {
    int left = 0;
    int right = 0;
    for (int w : weights) {
      left = Math.max(left, w);
      right += w;
    }
    while (left < right) {
      int mid = (left + right) / 2;
      if (solve(weights, mid, days)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public boolean solve(int[] arr, int mid, int days) {
    int count = 1;
    int curr = 0;
    for (int w : arr) {
      curr += w;
      if (curr > mid) {
        count++;
        curr = w;
      }
      if (count > days) {
        return false;
      }
    }
    return true;
  }
}
