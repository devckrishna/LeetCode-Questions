import java.util.*;

public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    Set<Character> set = new HashSet<>();
    Map<Character, Integer> map = new HashMap<>();
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!set.contains(ch)) {
        while (!st.isEmpty() && ch < st.peek() && map.get(st.peek()) > i) {
          set.remove(st.pop());
        }
        set.add(ch);
        st.add(ch);
      }
    }
    StringBuilder ans = new StringBuilder();
    for (char ch : st) {
      ans.append(ch);
    }
    return ans.toString();
  }
}
