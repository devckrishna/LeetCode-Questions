import java.util.*;

public class JumpGame4 {

  public int minJumps(int[] arr) {
    if (arr.length == 1) {
      return 0;
    }
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
    }
    Deque<Integer> qu = new LinkedList<>();
    boolean[] visited = new boolean[arr.length];
    visited[0] = true;
    qu.add(0);
    int ans = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int temp = qu.poll();
        if (temp == arr.length - 1) {
          return ans;
        }
        List<Integer> list = graph.get(arr[temp]);
        list.add(temp + 1);
        list.add(temp - 1);
        for (Integer curr : list) {
          if (curr >= 0 && curr < arr.length && !visited[curr]) {
            visited[curr] = true;
            qu.add(curr);
          }
        }

        list.clear();
      }
      ans++;
    }

    return -1;
  }
}
