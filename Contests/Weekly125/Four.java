import java.util.*;

public class Four {
  int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 },
      { 0, 0 } };

  public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    int[] ans = new int[queries.length];

    Map<Integer, Integer> row = new HashMap<>();
    Map<Integer, Integer> col = new HashMap<>();
    Map<Integer, Integer> d1 = new HashMap<>();
    Map<Integer, Integer> d2 = new HashMap<>();
    Map<Integer, Boolean> status = new HashMap<>();

    for (int i = 0; i < lamps.length; i++) {
      int r = lamps[i][0];
      int c = lamps[i][1];
      if (!status.containsKey(N * r + c)) {
        row.put(r, row.getOrDefault(r, 0) + 1);
        col.put(c, col.getOrDefault(c, 0) + 1);
        d1.put(r - c, d1.getOrDefault(r - c, 0) + 1);
        d2.put(r + c, d2.getOrDefault(r + c, 0) + 1);
        status.put(N * r + c, true);
      }
    }

    for (int i = 0; i < queries.length; i++) {
      int r = queries[i][0];
      int c = queries[i][1];

      ans[i] = (row.getOrDefault(r, 0) > 0 || col.getOrDefault(c, 0) > 0 || d1.getOrDefault(r - c, 0) > 0
          || d2.getOrDefault(r + c, 0) > 0) ? 1 : 0;

      for (int[] d : dir) {
        int r1 = r + d[0], c1 = c + d[1];
        if (r1 >= 0 && r1 < N && c1 >= 0 && c1 < N)
          if (status.containsKey(N * r1 + c1) && status.get(N * r1 + c1)) {
            row.put(r1, row.getOrDefault(r1, 1) - 1);
            col.put(c1, col.getOrDefault(c1, 1) - 1);
            d1.put(r1 - c1, d1.getOrDefault(r1 - c1, 1) - 1);
            d2.put(r1 + c1, d2.getOrDefault(r1 + c1, 1) - 1);
            status.put(N * r1 + c1, false);
          }
      }

    }
    return ans;
  }
}