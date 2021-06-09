import java.util.*;

public class SubstringOfSizeThreeWithDistinctCharacters {
  public int countGoodSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length() - 2; i++) {
      Set<Character> map = new HashSet<>();
      for (int j = i; j < i + 3; j++) {
        map.add(s.charAt(j));
      }
      if (map.size() == 3) {
        count++;
      }
    }
    return count;
  }
}