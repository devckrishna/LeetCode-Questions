public class Second {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int curr = 0;
    int ans = 0;
    for (int diff : differences) {
      curr += diff;
      min = Math.min(min, curr);
      max = Math.max(max, curr);
    }
    for (int i = lower; i <= upper; i++) {
      if (i + min < lower || i + max > upper) {
        continue;
      } else {
        ans++;
      }
    }
    return ans;
  }

}
