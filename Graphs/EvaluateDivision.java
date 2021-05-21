import java.util.*;

public class EvaluateDivision {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, HashMap<String, Double>> graph = buildGraph(equations, values);
    double[] ans = new double[queries.size()];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = dfs(graph, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
    }

    return ans;
  }

  public Map<String, HashMap<String, Double>> buildGraph(List<List<String>> arr, double[] values) {
    Map<String, HashMap<String, Double>> graph = new HashMap<>();
    String u;
    String v;
    for (int i = 0; i < arr.size(); i++) {
      u = arr.get(i).get(0);
      v = arr.get(i).get(1);
      graph.putIfAbsent(u, new HashMap<>());
      graph.get(u).put(v, values[i]);

      graph.putIfAbsent(v, new HashMap<>());
      graph.get(v).put(u, 1 / values[i]);
    }

    return graph;
  }

  public double dfs(Map<String, HashMap<String, Double>> graph, Set<String> visited, String start, String end) {
    if (!graph.containsKey(start)) {
      return -1.0;
    }
    if (graph.get(start).containsKey(end)) {
      return graph.get(start).get(end);
    }
    visited.add(start);
    for (Map.Entry<String, Double> nei : graph.get(start).entrySet()) {
      if (!visited.contains(nei.getKey())) {
        double temp = dfs(graph, visited, nei.getKey(), end);
        if (temp != -1.0) {
          return nei.getValue() * temp;
        }
      }
    }
    return -1.0;
  }

}
