import java.util.Arrays;

public class RemoveCoveredIntervals {
  public int removeCoveredIntervals(int[][] intervals) {
    int ans = 0;
    int end = -1;
    Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
    for (int[] curr : intervals) {
      if (curr[1] <= end) {
        ans++;
      } else {
        end = curr[1];
      }
    }
    return intervals.length - ans;
  }
}
