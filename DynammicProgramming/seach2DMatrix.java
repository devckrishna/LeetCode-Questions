import java.util.*;

public class seach2DMatrix {
  public int solve(ArrayList<ArrayList<Integer>> a, int b) {
    if (a.size() < 1)
      return 0;

    int yLength = a.get(0).size();

    int max = (a.size() * yLength) - 1;
    int min = 0;
    int mid;
    int x;
    int y;
    while (min <= max) {
      mid = min + ((max - min) / 2);
      x = mid / yLength;
      y = mid % yLength;
      if (a.get(x).get(y) == b) {
        return 1;
      } else if (a.get(x).get(y) > b) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    return 0;

  }

  public boolean searchMatrix(int[][] matrix, int target) {
    ArrayList<ArrayList<Integer>> curr = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      curr.add(new ArrayList<>());
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        curr.get(i).add(matrix[i][j]);
      }
    }
    if (solve(curr, target) == 1) {
      return true;
    } else {
      return false;
    }
  }
}
