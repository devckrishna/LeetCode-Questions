public class SearchIn2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int start = 0;
    int end = matrix.length * matrix[0].length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      int row = mid / matrix[0].length;
      int col = mid % matrix[0].length;
      int curr = matrix[row][col];
      if (curr >= target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return matrix[end / matrix[0].length][end % matrix[0].length] == target;
  }
}
