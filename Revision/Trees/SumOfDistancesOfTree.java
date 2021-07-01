import java.util.*;

public class SumOfDistancesOfTree {
  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    if (n == 1) {
      int[] temp = new int[1];
      temp[0] = 0;
      return temp;
    }
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
    }
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = bfs(graph, i, n);
    }
    return ans;
  }

  public int bfs(Map<Integer, List<Integer>> graph, int src, int n) {
    Queue<Integer> qu = new LinkedList<>();
    qu.add(src);
    int ans = 0;
    int level = 1;
    boolean[] visited = new boolean[n];
    visited[src] = true;
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int temp = qu.remove();
        visited[temp] = true;
        List<Integer> neis = graph.get(temp);
        int nei = 0;
        for (int ne : neis) {
          if (!visited[ne]) {
            nei++;
          }
        }
        ans += level * nei;

        for (int ne : neis) {
          if (!visited[ne]) {
            qu.add(ne);
          }
        }
      }
      level++;

    }
    return ans;
  }
}
