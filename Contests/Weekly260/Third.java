public class Third {
  public boolean isValid(char[][] board, int r, int c) {
    return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
  }

  public boolean placeWordInCrossword(char[][] board, String word) {
    int n = board.length, m = board[0].length, dirs[][] = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
          for (int[] dir : dirs) {
            int r = i, c = j, idx = 0;
            if (isValid(board, r - dir[0], c - dir[1]) && board[r - dir[0]][c - dir[1]] != '#')
              continue;

            while (idx < word.length() && isValid(board, r, c)) {
              if (board[r][c] == '#' || (board[r][c] != ' ' && board[r][c] != word.charAt(idx)))
                break;
              idx++;
              r += dir[0];
              c += dir[1];
            }

            if (idx == word.length() && (!isValid(board, r, c) || board[r][c] == '#'))
              return true;
          }
        }

      }
    }

    return false;
  }
}
