import java.util.*;

public class Third {
  public int[] maximumBeauty(int[][] items, int[] queries) {
    int[] result = new int[queries.length];
    Arrays.sort(items, (a, b) -> (a[0] - b[0]));

    TreeMap<Integer, Integer> map = new TreeMap<>() {
      {
        put(0, 0);
      }
    };
    for (int[] item : items) {
      int prev = map.floorEntry(item[0]).getValue();
      int hi = Math.max(prev, item[1]);

      map.put(item[0], hi);
    }

    for (int i = 0; i < queries.length; ++i)
      result[i] = map.floorEntry(queries[i]).getValue();

    return result;
  }
}