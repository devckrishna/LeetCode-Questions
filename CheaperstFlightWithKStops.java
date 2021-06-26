import java.util.*;

public class CheaperstFlightWithKStops {
  public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
    int[][] dp = new int[k + 2][n];
    for (int i = 0; i <= k + 1; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i <= k + 1; i++) {
      dp[i][src] = 0;
    }

    for (int i = 1; i <= k + 1; i++) {
      for (int[] f : flights) {
        if (dp[i - 1][f[0]] != Integer.MAX_VALUE) {
          dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i - 1][f[0]] + f[2]);
        }
      }
    }
    return dp[k + 1][dst] == Integer.MAX_VALUE ? -1 : dp[k + 1][dst];
  }

  // TLE--------------------
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    Map<Integer, Map<Integer, Integer>> g = buildGraph(flights);

    Queue<Flight> q = new PriorityQueue<>(Comparator.comparingInt(f -> f.cost));

    q.add(new Flight(0, src, 0));

    while (!q.isEmpty()) {
      Flight f = q.poll();

      if (f.hops > K + 1) {
        continue;
      }

      if (f.to == dst) {
        return f.cost;
      }

      for (Map.Entry<Integer, Integer> u : g.getOrDefault(f.to, new HashMap<>()).entrySet()) {
        int to = u.getKey();

        int costSum = f.cost + u.getValue();
        q.add(new Flight(costSum, to, f.hops + 1));
      }
    }

    return -1;
  }

  Map<Integer, Map<Integer, Integer>> buildGraph(int[][] flights) {
    Map<Integer, Map<Integer, Integer>> g = new HashMap<>();

    for (int[] edge : flights) {
      Map<Integer, Integer> u = g.getOrDefault(edge[0], new HashMap<>());
      u.put(edge[1], edge[2]);

      g.put(edge[0], u);
    }

    return g;
  }

  class Flight {
    int cost;
    int to;
    int hops;

    Flight(int cost, int to, int hops) {
      this.cost = cost;
      this.to = to;
      this.hops = hops;
    }
  }

  // ------------TLE
  int min = Integer.MAX_VALUE;

  public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int f[] : flights) {
      map.computeIfAbsent(f[0], m -> new HashMap<>()).put(f[1], f[2]);
    }
    boolean[] visited = new boolean[n];
    visited[src] = true;
    dfs(map, visited, 0, src, dst, K + 1);
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private void dfs(Map<Integer, Map<Integer, Integer>> map, boolean[] visited, int val, int cur, int dst, int k) {
    if (k < 0)
      return;
    if (cur == dst) {
      min = Math.min(min, val);
    }
    Map<Integer, Integer> next = map.getOrDefault(cur, null);
    if (next == null)
      return;
    for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
      if (visited[entry.getKey()])
        continue;
      if (val + entry.getValue() >= min)
        continue;
      visited[entry.getKey()] = true;
      dfs(map, visited, val + entry.getValue(), entry.getKey(), dst, k - 1);
      visited[entry.getKey()] = false;
    }
  }
}
