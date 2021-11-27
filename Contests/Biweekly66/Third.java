public class Third {
  public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
    int ans = 0;
    int startRow = startPos[0];
    int startCol = startPos[1];
    int endRow = homePos[0];
    int endCol = homePos[1];

    if (startRow < endRow) {
      for (int i = startRow + 1; i <= endRow; i++) {
        ans += rowCosts[i];
      }
    } else if (startRow > endRow) {
      for (int i = startRow - 1; i >= endRow; i--) {
        ans += rowCosts[i];
      }
    } else {
      ans = 0;
    }

    if (startCol < endCol) {
      for (int i = startCol + 1; i <= endCol; i++) {
        ans += colCosts[i];
      }
    } else if (startCol > endCol) {
      for (int i = startCol - 1; i >= endCol; i--) {
        ans += colCosts[i];
      }
    } else {
      ans += 0;
    }

    return ans;
  }
}
