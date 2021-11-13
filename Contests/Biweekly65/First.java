import java.util.*;

public class First {
  public boolean checkAlmostEquivalent(String word1, String word2) {
    Map<Character, Integer> first = new HashMap<>();
    Map<Character, Integer> second = new HashMap<>();
    for (int i = 0; i < word1.length(); i++) {
      char ch1 = word1.charAt(i);
      char ch2 = word2.charAt(i);
      first.put(ch1, first.getOrDefault(ch1, 0) + 1);
      second.put(ch2, second.getOrDefault(ch2, 0) + 1);
    }

    for (char ch : first.keySet()) {
      int one = first.get(ch);
      int two = second.getOrDefault(ch, 0);
      if (Math.abs(one - two) > 3) {
        return false;
      }
    }

    for (char ch : second.keySet()) {
      int one = second.get(ch);
      int two = first.getOrDefault(ch, 0);
      if (Math.abs(one - two) > 3) {
        return false;
      }
    }

    return true;
  }
}