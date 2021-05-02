public class CountSubmatricesOfAllOnes {
  public int countSquares(int[][] matrix) {
    if (matrix == null) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          continue;
        } else if (i >= 1 && j >= 1) {
          matrix[i][j] = Math.min(Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1), matrix[i - 1][j - 1] + 1);

        }
        res += matrix[i][j];
      }
    }

    return res;
  }
}