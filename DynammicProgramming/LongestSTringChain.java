import java.util.*;

public class LongestSTringChain {
  public int longestStrChain(String[] words) {
    HashMap<String, Integer> map = new HashMap<>();
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    int ans = 0;
    for (String word : words) {
      int best = 0;
      for (int i = 0; i < word.length(); i++) {
        String curr = word.substring(0, i) + word.substring(i + 1);
        best = Math.max(best, map.getOrDefault(curr, 0) + 1);
      }
      map.put(word, best);
      ans = Math.max(ans, best);
    }
    return ans;
  }
}
