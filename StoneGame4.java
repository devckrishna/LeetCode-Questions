import java.util.*;

public class StoneGame4 {
  public boolean winnerSquareGame(int n) {
    Map<Integer, Boolean> map = new HashMap<>();
    map.put(0, false);
    return dfs(n, map);
  }

  public boolean dfs(int n, Map<Integer, Boolean> map) {
    if (map.containsKey(n)) {
      return map.get(n);
    }
    int turn = (int) Math.sqrt(n);
    for (int i = 1; i <= turn; i++) {
      if (!dfs(n - i * i, map)) {
        map.put(n, true);
        return true;
      }
    }
    map.put(n, false);
    return false;
  }
}
