import java.util.*;

public class WordBreak2 {
  static Map<String, List<String>> dp;

  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    dp = new HashMap<>();
    for (String str : wordDict) {
      set.add(str);
    }
    return wordBreakDP(s, set);
  }

  public List<String> wordBreakDP(String s, Set<String> set) {
    if (dp.containsKey(s)) {
      return dp.get(s);
    }
    List<String> ans = new ArrayList<>();
    if (set.contains(s)) {
      ans.add(s);
    }
    for (int i = 0; i < s.length(); i++) {
      String left = s.substring(0, i);
      String right = s.substring(i);
      if (set.contains(left)) {
        for (String str : wordBreakDP(right, set)) {
          ans.add(left + " " + str);
        }
      }
    }
    dp.put(s, ans);
    return ans;
  }
}
