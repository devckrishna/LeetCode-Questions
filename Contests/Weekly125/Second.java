public class Second {
  public int numRookCaptures(char[][] board) {
    int ans = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 'R') {
          int index = i;
          while (index < board.length) {
            if (board[index][j] == 'p') {
              ans++;
              break;
            }
            if (board[index][j] == 'B') {
              break;
            }
            index++;
          }
          index = i;
          while (index >= 0) {
            if (board[index][j] == 'p') {
              ans++;
              break;
            }
            if (board[index][j] == 'B') {
              break;
            }
            index--;
          }
          index = j;
          while (index < board.length) {
            if (board[i][index] == 'p') {
              ans++;
              break;
            }
            if (board[i][index] == 'B') {
              break;
            }
            index++;
          }
          index = j;
          while (index >= 0) {
            if (board[i][index] == 'p') {
              ans++;
              break;
            }
            if (board[i][index] == 'B') {
              break;
            }
            index--;
          }
        }
      }
    }
    return ans;
  }
}
