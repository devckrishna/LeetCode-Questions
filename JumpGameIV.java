import java.util.*;

public class JumpGameIV {
  public int minJumps(int[] arr) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.putIfAbsent(arr[i], new ArrayList<>());
      map.get(arr[i]).add(i);
    }
    Queue<Integer> qu = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    qu.add(0);
    visited.add(0);
    int steps = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();
      for (int i = 0; i < size; i++) {
        int index = qu.poll();
        visited.add(index);
        if (index == arr.length - 1) {
          return steps;
        }
        if (index + 1 < arr.length && !visited.contains(index + 1)) {
          qu.add(index + 1);
        }
        if (index - 1 >= 0 && !visited.contains(index - 1)) {
          qu.add(index - 1);
        }
        List<Integer> curr = map.get(arr[index]);
        for (int temp : curr) {
          if (!visited.contains(temp)) {
            qu.add(temp);
          }
        }
        curr.clear();
      }
      steps++;
    }

    return steps;
  }
}
