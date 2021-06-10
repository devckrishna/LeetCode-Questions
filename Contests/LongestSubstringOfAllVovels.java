import java.util.HashSet;
import java.util.Set;

public class LongestSubstringOfAllVovels {
  public int longestBeautifulSubstring(String word) {
    int ans = 0;
    int currCount = 0;
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    int sortCount = 'a';
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) >= sortCount) {
        sortCount = word.charAt(i);
        currCount++;
        if (set.contains(word.charAt(i))) {
          set.remove(word.charAt(i));
        }
        if (set.size() == 0) {
          ans = Math.max(ans, currCount);
        }
      } else {
        sortCount = word.charAt(i);
        currCount = 1;
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.remove(word.charAt(i));
      }
    }

    return ans;
  }
}
