import java.util.*;

public class Third {
  public int wordCount(String[] startWords, String[] targetWords) {
    int ans = 0;
    Set<String> set = new HashSet<>();
    for (String word : startWords) {
      char[] ch = word.toCharArray();
      Arrays.sort(ch);
      set.add(new String(ch));
    }

    for (String word : targetWords) {
      for (int i = 0; i < word.length(); i++) {
        String curr = word.substring(0, i) + word.substring(i + 1);
        char[] ch = curr.toCharArray();
        Arrays.sort(ch);
        if (set.contains(new String(ch))) {
          ans++;
          break;
        }
      }
    }

    return ans;
  }
}
