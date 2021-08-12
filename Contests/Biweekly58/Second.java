public class Second {
  public static boolean check(char[][] board, int n, int m, int r, int c, char color) {
    int[] dx = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
    int[] dy = new int[] { 1, -1, 0, 1, -1, 0, 1, -1 };
    for (int i = 0; i < 8; i++) {
      int x = r + dx[i], y = c + dy[i];
      int count = 0;
      while (x < n && y < m && x >= 0 && y >= 0) {
        count++;
        if (board[x][y] == color) {
          if (count >= 2)
            return true;
          break;
        } else if (board[x][y] == '.')
          break;
        x += dx[i];
        y += dy[i];
      }
    }
    return false;
  }

  public boolean checkMove(char[][] board, int r, int c, char color) {
    int n = board.length, m = board[0].length;
    return check(board, n, m, r, c, color);
  }
}
