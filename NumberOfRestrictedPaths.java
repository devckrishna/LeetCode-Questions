import java.util.*;

public class NumberOfRestrictedPaths {
  Map<Integer, List<int[]>> graph = new HashMap<>();
  private final static int mod = 1_000_000_007;

  public int countRestrictedPaths(int n, int[][] edges) {
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] { edge[1], edge[2] });
      graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[] { edge[0], edge[2] });
    }
    PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    qu.add(new int[] { n, 0 });
    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[n] = 0;
    while (!qu.isEmpty()) {
      int[] temp = qu.poll();
      int node = temp[0];
      int weight = temp[1];
      for (int[] neighbour : graph.get(node)) {
        int nei = neighbour[0];
        int w = weight + neighbour[1];
        if (w < dist[nei]) {
          dist[nei] = w;
          qu.add(new int[] { nei, w });
        }
      }
    }
    Integer[] dp = new Integer[n + 1];
    return dfs(1, n, dist, dp);
  }

  public int dfs(int node, int end, int[] dist, Integer[] dp) {
    if (node == end) {
      return 1;
    }
    if (dp[node] != null) {
      return dp[node];
    }
    int res = 0;
    for (int[] neighbour : graph.get(node)) {
      int nei = neighbour[0];
      if (dist[nei] < dist[node]) {
        res = (res + dfs(nei, end, dist, dp)) % mod;
      }
    }
    res = res % mod;
    return dp[node] = (int) res;

  }
}
