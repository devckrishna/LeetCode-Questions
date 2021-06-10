import java.util.*;

public class FindEventualSafeStates {
  public List<Integer> eventualSafeNodes(int[][] grid) {
    int[] color = new int[grid.length];
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      if (dfs(grid, color, i)) {
        ans.add(i);
      }
    }

    return ans;
  }

  public boolean dfs(int[][] grid, int[] color, int index) {
    if (color[index] > 0) {
      return color[index] == 2;
    }
    color[index] = 1;
    for (int curr : grid[index]) {
      if (color[index] == 2) {
        continue;
      }
      if (color[curr] == 1 || !dfs(grid, color, curr)) {
        return false;
      }
    }

    color[index] = 2;
    return true;
  }
}
