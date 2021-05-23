public class SolveSudoku {
  char[][] board;
  int N;

  public void solveSudoku(char[][] board) {
    this.board = board;
    this.N = board.length;
    backTracking(0, 0);
  }

  public boolean backTracking(int row, int col) {
    if (row == N - 1 && col == N) {
      return true;
    }

    if (col == N) { // if we cross last column in board we go to next column
      row++;
      col = 0;
    }

    if (board[row][col] != '.') // if board[row][col] has a number we go to next available slot
      return backTracking(row, col + 1);

    for (char num = '1'; num <= '9'; num++) {
      if (validateNumber(row, col, num)) { // check if number fits in that slot
        board[row][col] = num;
        if (backTracking(row, col + 1)) { // we will continue backtracking if we found our number
          return true;
        }
      }
      board[row][col] = '.'; // if number is not fit then we will rollback to '.'
    }

    return false;
  }

  public boolean validateNumber(int row, int col, char num) {
    return !isInRow(row, col, num) && !isInCol(row, col, num) && !isInBox(row, col, num);
  }

  public boolean isInRow(int row, int col, char num) {
    for (int i = 0; i < N; i++) {
      if (board[row][i] == num)
        return true;
    }

    return false;
  }

  public boolean isInCol(int row, int col, char num) {
    for (int i = 0; i < N; i++) {
      if (board[i][col] == num)
        return true;
    }

    return false;
  }

  public boolean isInBox(int row, int col, char num) {
    int startRow = row - row % 3, startCol = col - col % 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i + startRow][j + startCol] == num)
          return true;
      }
    }

    return false;
  }
}
