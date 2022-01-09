import java.util.*;

public class Third {
  public int longestPalindrome(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    int ans = 0;
    Map<String, Boolean> m = new HashMap<>();
    for (String curr : map.keySet()) {
      String first = curr;
      String second = curr.charAt(1) + "";
      second += curr.charAt(0);
      if (!first.equals(second)) {
        if (!m.getOrDefault(first, false) && !m.getOrDefault(second, false)) {
          int diff = Math.min(map.getOrDefault(first, 0), map.getOrDefault(second, 0));
          ans += diff * 4;
          m.put(first, true);
          m.put(second, true);
        }
      }
    }

    Map<String, Integer> temp = new HashMap<>();
    for (String word : words) {
      String first = word;
      String second = word.charAt(1) + "";
      second += word.charAt(0);
      if (first.equals(second)) {
        temp.put(first, temp.getOrDefault(first, 0) + 1);
      }
    }

    boolean flag = false;
    for (String key : temp.keySet()) {
      if (temp.get(key) % 2 == 0) {
        ans += temp.get(key) * 2;
      } else {
        if (!flag) {
          ans += 2;
          flag = true;
        }
        int diff = temp.get(key) - 1;
        ans += diff * 2;
      }
    }
    return ans;

  }
}