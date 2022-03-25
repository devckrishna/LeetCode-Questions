import java.util.*;

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] first, int[] second) {
        return first[0] - first[1] - (second[0] - second[1]);
      }
    });

    int ans = 0;
    int n = costs.length / 2;
    for (int i = 0; i < n; ++i) {
      ans += costs[i][0] + costs[i + n][1];
    }
    return ans;
  }
}
