import java.util.*;

public class NumberOfSubMatricesThatSumTarget {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int ans = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        matrix[i][j] += matrix[i][j - 1];
      }
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
        map.clear();
        map.put(0, 1);
        int curr = 0;
        for (int k = 0; k < matrix.length; k++) {
          curr += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
          if (map.containsKey(curr - target)) {
            ans += map.get(curr - target);
          }
          map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
      }
    }
    return ans;
  }
}