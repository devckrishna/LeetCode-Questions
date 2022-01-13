import java.util.*;

public class MinumNumberOfArrowsToBurstBaloons {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> a[0] - b[0]);
    int ans = 1;
    int start = points[0][0];
    int end = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int[] point = points[i];
      if (point[0] <= end && point[0] >= start) {
        start = Math.min(point[0], start);
        end = Math.min(point[1], end);
      } else {
        start = point[0];
        end = point[1];
        ans++;
      }
    }

    return ans;
  }
}
