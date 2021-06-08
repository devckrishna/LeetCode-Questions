import java.util.*;

public class PossibleBipartition {
  public boolean possibleBipartition(int N, int[][] dislikes) {
    if (N <= 2)
      return true;
    List<Integer>[] adj = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int[] edge : dislikes) {
      adj[edge[0]].add(edge[1]);
      adj[edge[1]].add(edge[0]);
    }
    int[] colors = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      if (colors[i] == 0) {
        if (!dfs(i, adj, colors, 1)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean dfs(int node, List<Integer>[] adj, int[] colors, int color) {
    if (colors[node] != 0) {
      return colors[node] == color;
    }
    colors[node] = color;
    for (int neighbor : adj[node]) {
      if (!dfs(neighbor, adj, colors, -color)) {
        return false;
      }
    }
    return true;
  }
}
