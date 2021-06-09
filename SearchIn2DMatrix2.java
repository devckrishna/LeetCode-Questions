public class SearchIn2DMatrix2 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0;
    int col = matrix[0].length - 1;
    while (col >= 0 && row < matrix.length) {
      if (matrix[row][col] == target) {
        return true;
      } else if (target < matrix[row][col]) {
        col--;
      } else if (target > matrix[row][col]) {
        row++;
      }
    }
    return false;
  }
}
