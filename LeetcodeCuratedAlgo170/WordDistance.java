import java.util.*;

public class WordDistance {
  Map<String, List<Integer>> map;

  public WordDistance(String[] wordsDict) {
    map = new HashMap<>();
    for (int i = 0; i < wordsDict.length; i++) {
      String str = wordsDict[i];
      if (!map.containsKey(str)) {
        map.put(str, new ArrayList<>());
      }
      map.get(str).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> first = map.get(word1);
    List<Integer> second = map.get(word2);
    int ans = Integer.MAX_VALUE;
    int i = 0;
    int j = 0;
    while (i < first.size() && j < second.size()) {
      ans = Math.min(Math.abs(first.get(i) - second.get(j)), ans);
      if (first.get(i) < second.get(j)) {
        i++;
      } else {
        j++;
      }
    }
    return ans;
  }
}
