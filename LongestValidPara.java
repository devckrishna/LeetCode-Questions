import java.util.*;

class LongestValidPara {

  public int longestValidParentheses(String s) {
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.push(i);
      } else {
        st.pop();
        if (st.isEmpty()) {
          st.push(i);
        } else {
          ans = Math.max(ans, i - st.peek());
        }
      }
    }
    return ans;
  }

  public int longestValidParentheses2(String s) {
    int maxans = 0;
    int dp[] = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }
        maxans = Math.max(maxans, dp[i]);
      }
    }
    return maxans;
  }
}
