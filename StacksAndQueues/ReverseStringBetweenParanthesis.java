import java.util.*;

class ReverseStringBetweenParanthesis {
  public String reverseParentheses(String s) {
    String res = "";
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == ')') {
        res = "";
        while (st.peek() != '(') {
          res += st.pop();
        }
        st.pop();
        for (char c : res.toCharArray()) {
          st.push(c);
        }
      } else {
        st.push(ch);
      }
    }
    res = "";
    for (char c : st) {
      res += c;
    }
    return res;
  }
}
