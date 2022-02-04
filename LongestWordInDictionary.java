import java.util.*;

public class LongestWordInDictionary {
  public String longestWord(String[] words) {
    Set<String> set = new HashSet<>();
    for (String word : words) {
      set.add(word);
    }
    String ans = "";
    for (String word : words) {
      boolean flag = false;
      for (int i = 1; i < word.length(); i++) {
        if (!set.contains(word.substring(0, i))) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        if (ans.length() < word.length()) {
          ans = word;
        } else if (ans.length() == word.length() && ans.compareTo(word) > 0) {
          ans = word;
        }
      }
    }
    return ans;
  }
}
