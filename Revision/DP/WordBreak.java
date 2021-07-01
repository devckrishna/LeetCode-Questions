import java.util.*;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < wordDict.size(); i++) {
      set.add(wordDict.get(i));
    }
    boolean[] dp = new boolean[s.length()];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j <= i; j++) {
        String sub = s.substring(j, i + 1);
        if (set.contains(sub) && (j == 0 || dp[j - 1])) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[dp.length - 1];
  }
}
