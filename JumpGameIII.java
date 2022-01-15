import java.util.*;

public class JumpGameIII {

  public boolean canReach(int[] arr, int start) {
    Queue<Integer> qu = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    qu.add(start);
    visited.add(start);
    while (!qu.isEmpty()) {
      int size = qu.size();
      for (int i = 0; i < size; i++) {
        int index = qu.poll();
        visited.add(index);
        if (arr[index] == 0) {
          return true;
        }
        if (index + arr[index] < arr.length && !visited.contains(index + arr[index])) {
          qu.add(index + arr[index]);
        }
        if (index - arr[index] >= 0 && !visited.contains(index - arr[index])) {
          qu.add(index - arr[index]);
        }
      }
    }
    return false;
  }
}
