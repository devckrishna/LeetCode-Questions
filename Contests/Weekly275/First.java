import java.util.*;

public class First {
  public boolean checkValid(int[][] matrix) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      set = new HashSet<>();
      for (int j = 0; j < matrix.length; j++) {
        set.add(matrix[i][j]);
      }
      if (set.size() < matrix.length) {
        return false;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      set = new HashSet<>();
      for (int j = 0; j < matrix.length; j++) {
        set.add(matrix[j][i]);
      }
      if (set.size() < matrix.length) {
        return false;
      }
    }
    return true;
  }
}