import java.util.*;

public class MinJumpsToReachHome {
  public int minimumJumps(int[] forbidden, int a, int b, int x) {
    PriorityQueue<int[]> qu = new PriorityQueue<>((a0, b0) -> a0[0] - b0[0]);
    qu.add(new int[] { 0, 0, 0 });
    Set<Integer> forbid = new HashSet<>();
    Set<String> visited = new HashSet<>();
    int maxLimit = 2000 + 2;
    for (int f : forbidden) {
      forbid.add(f);
      maxLimit = Math.max(maxLimit, f + 2 * b);
    }
    while (!qu.isEmpty()) {
      int[] temp = qu.poll();
      int step = temp[0];
      int index = temp[1];
      int dir = temp[2];
      if (index == x) {
        return step;
      }
      if (index + a < maxLimit && !forbid.contains(index + a) && !visited.contains(index + a + "," + 0)) {
        visited.add(index + a + "," + 0);
        qu.add(new int[] { step + 1, index + a, 0 });
      }
      if (index - b >= 0 && !forbid.contains(index - b) && !visited.contains(index - b + "," + 1) && dir != 1) {
        visited.add(index - b + "," + 1);
        qu.add(new int[] { step + 1, index - b, 1 });
      }
    }
    return -1;
  }
}
