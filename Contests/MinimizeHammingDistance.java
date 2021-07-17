import java.util.*;

public class MinimizeHammingDistance {
  public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    int n = source.length;
    int[] union = new int[n];
    for (int i = 0; i < n; i++) {
      union[i] = i;
    }
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] swap : allowedSwaps) {
      int first = find(union, swap[0]);
      int second = find(union, swap[1]);
      if (first == second) {
        continue;
      }
      union[first] = second;
    }

    for (int i = 0; i < n; i++) {
      int num = source[i];
      int root = find(union, i);
      map.putIfAbsent(root, new HashMap<>());
      Map<Integer, Integer> store = map.get(root);
      store.put(num, store.getOrDefault(num, 0) + 1);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int num = target[i];
      int root = find(union, i);
      map.putIfAbsent(root, new HashMap<>());
      Map<Integer, Integer> store = map.get(root);
      if (store.getOrDefault(num, 0) == 0) {
        ans++;
      } else {
        store.put(num, store.get(num) - 1);
      }
    }

    return ans;
  }

  public int find(int[] parent, int x) {
    if (parent[x] != x) {
      parent[x] = find(parent, parent[x]);
    }
    return parent[x];
  }
}
