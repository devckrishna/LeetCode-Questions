import java.util.*;

public class Second {
  public int minOperations(int[][] grid, int x) {
    List<Integer> arr = new ArrayList<>();
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        arr.add(grid[i][j]);
      }
    }

    Collections.sort(arr);
    int mid = arr.get(Math.max(0, arr.size() / 2 - 1));
    int mid2 = arr.get(arr.size() / 2);

    int first = 0;
    int second = 0;

    for (int num : arr) {
      if (Math.abs(mid - num) % x == 0 || x == 1) {
        first += Math.abs(mid - num) / x;
      } else {
        return -1;
      }
    }
    for (int num : arr) {
      if (Math.abs(mid2 - num) % x == 0 || x == 1) {
        second += Math.abs(mid2 - num) / x;
      } else {
        return -1;
      }
    }
    ans = Math.min(first, second);
    return ans;
  }
}
