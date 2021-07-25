import java.util.*;

public class CheckEqualNumberTimes {

  public boolean areOccurrencesEqual(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    int times = map.get(s.charAt(0));
    for (Map.Entry<Character, Integer> val : map.entrySet()) {
      if (val.getValue() != times) {
        return false;
      }
    }
    return true;
  }
}
