import java.util.*;

public class Third {
  static Map<Integer, Integer> set = new HashMap<>();

  public void solve(Map<Integer, Map<Integer, Integer>> graph, int src, int des, int sum, boolean[] visited) {
    if (src == des) {
      set.put(sum, set.getOrDefault(sum, 0) + 1);
      return;
    }
    if (visited[src]) {
      return;
    }
    visited[src] = true;
    for (Integer curr : graph.get(src)) {
      if (!visited[curr]) {
        solve(graph, curr, des, sum, visited);
      }
    }
  }

  public int countPaths(int n, int[][] times) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

    for (int[] time : times) {
      if (!graph.containsKey(time[0]))
        graph.put(time[0], new HashMap<Integer, Integer>());
      graph.get(time[0]).put(time[1], time[2]);
    }
    boolean[] visited = new boolean[n + 1];
    solve(graph, n, 0, visited, 0);
    return ans;
  }
}
