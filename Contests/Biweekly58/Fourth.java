public class Fourth {
  public boolean check(char[][] arr, int i, int j) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != '.') {
      return false;
    }
    return true;
  }

  public boolean checkMove(char[][] board, int i, int j, char c) {
    board[i][j] = c;
    int color = c == 'B' ? 'w' : 'B';
    if (check(board, i + 1, j)) {
      if (board[i + 1][j] == color) {

      }
    } else if (check(board, i - 1, j)) {

    } else if (check(board, i, j + 1)) {

    } else if (check(board, i, j - 1)) {

    } else if (check(board, i + 1, j + 1)) {

    } else if (check(board, i + 1, j - 1)) {

    } else if (check(board, i - 1, j - 1)) {

    } else if (check(board, i - 1, j + 1)) {

    }

    return false;
  }
}
