import java.util.*;

public class First {
  public int canBeTypedWords(String text, String brokenLetters) {
    Set<Character> set = new HashSet<>();
    for (char ch : brokenLetters.toCharArray()) {
      set.add(ch);
    }
    int ans = 0;
    String[] arr = text.split(" ");
    for (String str : arr) {
      boolean flag = false;
      for (char ch : str.toCharArray()) {
        if (set.contains(ch)) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        ans++;
      }
    }

    return ans;
  }
}