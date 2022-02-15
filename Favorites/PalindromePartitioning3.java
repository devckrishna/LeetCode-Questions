public class PalindromePartitioning3 {
  public int palindromePartition(String s, int k) {
    Integer[][] dp = new Integer[s.length()][k + 1];
    return solve(s, k, 0, dp);
  }

  public int solve(String s, int k, int index, Integer[][] dp) {
    if (index == s.length()) {
      if (k == 0) {
        return palCheck(s.substring(index));
      } else {
        return Integer.MAX_VALUE;
      }
    }
    if (k == 1) {
      return palCheck(s.substring(index));
    }
    if (dp[index][k] != null) {
      return dp[index][k];
    }
    int ans = Integer.MAX_VALUE;
    for (int i = index; i < s.length(); i++) {
      int left = palCheck(s.substring(index, i + 1));
      int right = solve(s, k - 1, i + 1, dp);
      if (right != Integer.MAX_VALUE) {
        ans = Math.min(ans, left + right);
      }
    }
    dp[index][k] = ans;
    return ans;
  }

  public int palCheck(String s) {
    int res = 0;
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        res++;
      }
      start++;
      end--;
    }
    return res;
  }
}
