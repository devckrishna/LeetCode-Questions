import java.util.*;

public class MaxScoreWordFromed {
  public int maxScoreWords(String[] words, char[] letters, int[] score) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : letters) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    return solve(words, map, score, 0, 0);
  }

  public int solve(String[] words, Map<Character, Integer> map, int[] score, int index, int curr) {
    if (index == words.length) {
      return 0;
    }
    int exclude = solve(words, map, score, index + 1, curr);
    String word = words[index];
    int count = 0;
    boolean valid = true;
    for (char ch : word.toCharArray()) {
      if (map.getOrDefault(ch, 0) == 0) {
        valid = false;
      }
      map.put(ch, map.getOrDefault(ch, 0) - 1);
      count += score[ch - 'a'];
    }
    int include = 0;
    if (valid) {
      include = count + solve(words, map, score, index + 1, curr);
    }
    for (char ch : word.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    return Math.max(include, exclude);
  }
}
