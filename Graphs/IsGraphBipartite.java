import java.util.*;

public class IsGraphBipartite {
  public boolean isBipartite(int[][] graph) {
    boolean[] visited = new boolean[100];
    boolean[] color = new boolean[100];

    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < graph.length; i++) {
      if (graph[i].length == 0 || visited[i]) {
        continue;
      }
      queue.add(i);
      visited[i] = true;
      color[i] = true;
      while (!queue.isEmpty()) {
        Integer node = queue.poll();
        for (int neighbor : graph[node]) {
          if (!visited[neighbor]) {
            queue.add(neighbor);
            visited[neighbor] = true;
            color[neighbor] = !color[node];
          } else if (color[neighbor] == color[node]) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
