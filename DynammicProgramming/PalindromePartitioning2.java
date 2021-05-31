public class PalindromePartitioning2 {
  Integer[][] dp;

  public int minCut(String s) {
    dp = new Integer[s.length()][s.length()];
    return solve(s, 0, s.length() - 1);
  }

  public int solve(String s, int start, int end) {
    if (start == end || isPal(s, start, end)) {
      return 0;
    }
    if (dp[start][end] != null) {
      return dp[start][end];
    }
    int cut = s.length() - 1;
    for (int i = start; i <= end; i++) {
      if (isPal(s, start, i)) {
        cut = Math.min(cut, 1 + solve(s, i + 1, end));
      }
    }

    dp[start][end] = cut;
    return cut;
  }

  public boolean isPal(String s, int start, int end) {
    int i = start;
    int j = end;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

}
