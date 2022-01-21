public class Third {
  int ans = 0;

  public boolean isPal(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }

  public void solve(String s, int index, String first, String second) {
    if (index == s.length()) {
      if (isPal(first) && isPal(second)) {
        ans = Math.max(ans, first.length() * second.length());
        return;
      }
      return;
    }
    solve(s, index + 1, first + s.charAt(index), second);
    solve(s, index + 1, first, second + s.charAt(index));
    solve(s, index + 1, first, second);
  }

  public int maxProduct(String s) {
    solve(s, 0, "", "");
    return ans;
  }
}
