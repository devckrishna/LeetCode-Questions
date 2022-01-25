import java.util.*;

public class BusRoutes {
  public int numBusesToDestination(int[][] routes, int source, int target) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        if (!map.containsKey(routes[i][j])) {
          map.put(routes[i][j], new HashSet<>());
        }
        map.get(routes[i][j]).add(i);
      }
    }
    Set<Integer> visited = new HashSet<>();
    boolean[] seenRoutes = new boolean[routes.length];
    Queue<int[]> qu = new LinkedList<>();
    qu.add(new int[] { source, 0 });
    visited.add(source);
    while (!qu.isEmpty()) {
      int[] curr = qu.poll();
      int src = curr[0];
      if (src == target) {
        return curr[1];
      }
      for (int bus : map.get(src)) {
        if (seenRoutes[bus])
          continue;
        for (int stop : routes[bus]) {
          if (!visited.contains(stop)) {
            qu.add(new int[] { stop, curr[1] + 1 });
            visited.add(stop);
          }
        }
        seenRoutes[bus] = true;
      }
    }

    return -1;
  }
}
