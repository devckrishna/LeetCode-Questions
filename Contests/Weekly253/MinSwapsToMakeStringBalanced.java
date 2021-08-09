import java.util.*;

public class MinSwapsToMakeStringBalanced {
  public int minSwaps(String s) {
    Stack<Integer> st = new Stack<>();
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '[') {
        st.push(i);
      } else {
        if (st.isEmpty()) {
          sb.setCharAt(i, '*');
        } else {
          st.pop();
        }
      }
    }
    while (!st.isEmpty()) {
      sb.setCharAt(st.pop(), '*');
    }
    int count = 0;
    for (char ch : sb.toString().toCharArray()) {
      if (ch == '*') {
        count++;
      }
    }
    count = count / 2;

    return (count + 1) / 2;
  }
}
