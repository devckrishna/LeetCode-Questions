import java.util.*;

public class Second {
  public long interchangeableRectangles(int[][] rectangles) {
    Map<Double, Integer> map = new HashMap<>();
    long ans = 0;
    for (int i = rectangles.length - 1; i >= 0; i--) {
      double ratio = (1.0 * rectangles[i][0]) / rectangles[i][1];
      ans += map.getOrDefault(ratio, 0);
      map.put(ratio, map.getOrDefault(ratio, 0) + 1);
    }
    return ans;
  }
}
