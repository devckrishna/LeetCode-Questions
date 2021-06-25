import java.util.*;

public class TimeNeededToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      if (manager[i] == -1) {
        continue;
      }
      graph.get(manager[i]).add(i);
    }
    return dfs(graph, headID, informTime);
  }

  public int dfs(List<List<Integer>> graph, int src, int[] info) {
    int ans = 0;
    for (Integer nei : graph.get(src)) {
      ans = Math.max(ans, dfs(graph, nei, info));
    }

    return ans + info[src];
  }
}
