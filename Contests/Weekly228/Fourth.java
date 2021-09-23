import java.util.*;

public class Fourth {
  public int minTrioDegree(int n, int[][] edges) {
    Map<Integer, Integer> map = new HashMap<>();
    boolean[][] graph = new boolean[n + 1][n + 1];

    for (int[] edge : edges) {
      map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
      map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
      graph[edge[0]][edge[1]] = true;
      graph[edge[1]][edge[0]] = true;
    }

    int ans = Integer.MAX_VALUE;
    for (int[] edge : edges) {
      for (int i = 1; i <= n; i++) {
        if (graph[i][edge[0]] && graph[i][edge[1]]) {
          int curr = map.get(edge[0]) + map.get(edge[1]) + map.get(i) - 6;
          ans = Math.min(ans, curr);
        }
      }
    }
    if (ans == Integer.MAX_VALUE) {
      return -1;
    }
    return ans;
  }
}
