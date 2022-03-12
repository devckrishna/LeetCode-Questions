import java.util.*;

public class MinimumKnightMoves {
  public int minKnightMoves(int x, int y) {
    x = Math.abs(x);
    y = Math.abs(y);
    Queue<int[]> qu = new LinkedList<>();
    qu.add(new int[] { 0, 0 });
    Set<String> visited = new HashSet<>();
    visited.add("0,0");
    int steps = 0;
    int[][] dirs = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };
    while (!qu.isEmpty()) {
      int size = qu.size();
      while (size-- > 0) {
        int[] curr = qu.poll();
        if (curr[0] == x && curr[1] == y) {
          return steps;
        }
        for (int[] dir : dirs) {
          int newx = dir[0] + curr[0];
          int newy = dir[1] + curr[1];
          int[] dest = new int[] { newx, newy };
          String temp = newx + "," + newy;
          if (!visited.contains(temp) && newx >= -1 && newy >= -1) {
            qu.add(dest);
            visited.add(temp);
          }
        }
      }
      steps++;
    }

    return -1;
  }
}
