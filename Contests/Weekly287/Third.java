import java.util.Arrays;

public class Third {
  private boolean solve(int[] arr, long k, int mid) {
    if (mid == 0) {
      return true;
    }
    long temp = 0;
    for (int curr : arr) {
      temp += (curr / mid);
    }
    return temp >= k;
  }

  public int maximumCandies(int[] candies, long k) {
    Arrays.sort(candies);
    int start = 0;
    int end = candies[candies.length - 1];
    int ans = 0;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (solve(candies, k, mid)) {
        start = mid + 1;
        ans = mid;
      } else {
        end = mid - 1;
      }
    }
    return ans;
  }
}
