import java.util.Stack;

public class RemoveKDigits {
  public String removeKdigits(String num, int k) {
    Stack<Character> s = new Stack<>();
    String res = "";
    for (int i = 0; i < num.length(); i++) {
      char c = num.charAt(i);
      while (k > 0 && !s.isEmpty() && Character.getNumericValue(c) < Character.getNumericValue(s.peek())) {
        s.pop();
        k--;
      }
      if (!s.isEmpty() || c != '0') {
        s.push(c);
      }
    }

    while (!s.isEmpty()) {
      res = s.pop() + res;
    }
    if (res.isEmpty())
      return "0";
    res = res.substring(0, res.length() - k);
    if (res.isEmpty())
      return "0";
    return res;
  }
}
