import java.util.*;

public class PalindromicPartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    boolean[][] dp = new boolean[s.length()][s.length()];
    solve(s, 0, ans, new ArrayList<>(), dp);
    return ans;
  }

  public void solve(String s, int start, List<List<String>> ans, List<String> temp, boolean[][] dp) {
    if (start == s.length()) {
      ans.add(new ArrayList<>(temp));
      return;
    }
    for (int end = start; end < s.length(); end++) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
        temp.add(s.substring(start, end + 1));
        dp[start][end] = true;
        solve(s, end + 1, ans, temp, dp);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
