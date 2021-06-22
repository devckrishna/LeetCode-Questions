import java.util.HashSet;
import java.util.Set;

public class NQueens2 {
  int ans = 0;
  Set<Integer> cols = new HashSet<>();
  Set<Integer> diag = new HashSet<>();
  Set<Integer> antiDiag = new HashSet<>();

  public int totalNQueens(int n) {
    solve(0, n);
    return ans;
  }

  public void solve(int row, int n) {
    for (int col = 0; col < n; col++) {
      if (cols.contains(col)) {
        continue;
      }
      int di = row + col;
      int adi = row - col;
      if (diag.contains(di)) {
        continue;
      }
      if (antiDiag.contains(adi)) {
        continue;
      }
      if (row == n - 1) {
        ans++;
      } else {
        cols.add(col);
        diag.add(di);
        antiDiag.add(adi);
        solve(row + 1, n);
        cols.remove(col);
        diag.remove(di);
        antiDiag.remove(adi);
      }
    }
  }
}
