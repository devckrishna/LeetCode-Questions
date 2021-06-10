class WordSearch {
  static boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (solve(board, i, j, 0, w)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean solve(char[][] board, int row, int col, int index, char[] w) {
    if (index == w.length) {
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
      return false;
    }
    if (w[index] != board[row][col]) {
      return false;
    }
    visited[row][col] = true;
    if (solve(board, row + 1, col, index + 1, w) || solve(board, row, col + 1, index + 1, w)
        || solve(board, row, col - 1, index + 1, w) || solve(board, row - 1, col, index + 1, w)) {
      return true;
    }
    visited[row][col] = false;
    return false;

  }
}