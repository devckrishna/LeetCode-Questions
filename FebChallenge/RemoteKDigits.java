import java.util.*;

public class RemoteKDigits {
  public String removeKdigits(String s, int k) {
    if (s.length() == k) {
      return "0";
    }
    Stack<Character> st = new Stack<>();
    int index = 0;
    while (index < s.length()) {
      while (k > 0 && !st.isEmpty() && st.peek() - '0' > s.charAt(index) - '0') {
        st.pop();
        k--;
      }
      st.push(s.charAt(index));
      index++;
    }
    while (k-- > 0) {
      st.pop();
    }
    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) {
      sb.append(st.pop());
    }
    String ans = sb.reverse().toString();
    index = 0;
    for (char ch : ans.toCharArray()) {
      if (ch != '0') {
        break;
      }
      index++;
    }
    return ans.substring(index).isBlank() ? "0" : ans.substring(index);
  }
}
