import java.util.*;

public class SortMatrixDiagonally {
  public int[][] diagonalSort(int[][] mat) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (!map.containsKey(i - j)) {
          ArrayList<Integer> curr = new ArrayList<>();
          curr.add(mat[i][j]);
          map.put(i - j, curr);
        } else {
          map.get(i - j).add(mat[i][j]);
        }
      }
    }

    for (ArrayList<Integer> entry : map.values()) {
      Collections.sort(entry);
    }
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        mat[i][j] = map.get(i - j).get(0);
        map.get(i - j).remove(0);
      }
    }
    return mat;
  }
}
