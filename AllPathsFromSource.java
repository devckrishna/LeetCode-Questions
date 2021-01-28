import java.util.*;

class AllPathsFromSource {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> ans = new ArrayList<>();
    if (graph.length == 0) {
      return ans;
    }
    List<Integer> path = new ArrayList<>();
    path.add(0);
    solve(graph, 0, path, ans);
    return ans;
  }

  public static void solve(int[][] graph, int src, List<Integer> path, List<List<Integer>> ans) {
    if (src == graph.length - 1) {
      ans.add(new ArrayList<Integer>(path));
      return;
    }
    for (Integer i : graph[src]) {
      path.add(i);
      solve(graph, i, path, ans);
      path.remove(path.size() - 1);
    }

  }

}