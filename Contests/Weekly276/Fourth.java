public class Fourth {
  public long maxRunTime(int n, int[] batteries) {
    long ans = -1;
    long sum = 0;
    for (int curr : batteries) {
      sum += curr;
    }
    long start = 0;
    long end = sum / n;
    while (start <= end) {
      long mid = start + (end - start) / 2;
      if (solve(n, mid, batteries)) {
        ans = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return ans;
  }

  public boolean solve(int n, long mid, int[] arr) {
    long target = n * mid;
    long currSum = 0;
    for (int curr : arr) {
      if (curr < mid) {
        currSum += curr;
      } else {
        currSum += mid;
      }
      if (currSum >= target) {
        return true;
      }
    }
    return currSum >= target;
  }
}
