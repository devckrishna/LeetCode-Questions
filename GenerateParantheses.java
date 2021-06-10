import java.util.*;

class GenerateParanthese {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    solve(ans, "", 0, 0, n);
    return ans;
  }

  public static void solve(List<String> ans, String ques, int open, int close, int n) {
    if (ques.length() == 2 * n) {
      ans.add(ques);
      return;
    }
    if (open < n)
      solve(ans, ques + "(", open + 1, close, n);
    if (close < open)
      solve(ans, ques + ")", open, close + 1, n);

  }
}