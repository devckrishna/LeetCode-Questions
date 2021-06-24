import java.util.*;

public class ConcatanatedWords {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> ans = new ArrayList<>();
    if (words.length == 0) {
      return ans;
    }
    Set<String> set = new HashSet<>();
    for (String word : words) {
      set.add(word);
    }
    for (String word : words) {
      if (solve(word, set)) {
        ans.add(word);
      }
    }

    return ans;
  }

  public boolean solve(String word, Set<String> set) {
    for (int i = 1; i < word.length(); i++) {
      String pre = word.substring(0, i);
      String suf = word.substring(i, word.length());
      if (set.contains(pre) && (set.contains(suf) || solve(suf, set))) {
        return true;
      }
    }
    return false;
  }
}
