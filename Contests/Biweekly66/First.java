import java.util.*;

public class First {
  public int countWords(String[] words1, String[] words2) {
    Map<String, Integer> first = new HashMap<>();
    Map<String, Integer> second = new HashMap<>();
    for (String curr : words1) {
      first.put(curr, first.getOrDefault(curr, 0) + 1);
    }
    for (String curr : words2) {
      second.put(curr, second.getOrDefault(curr, 0) + 1);
    }
    int ans = 0;
    for (String curr : words1) {
      if (first.getOrDefault(curr, 0) == 1 && second.getOrDefault(curr, 0) == 1) {
        ans++;
      }
    }
    return ans;
  }
}