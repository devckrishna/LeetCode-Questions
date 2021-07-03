import java.util.Stack;

public class LongestValidParenthesis {
  public int longestValidParentheses(String s) {
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
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
}
