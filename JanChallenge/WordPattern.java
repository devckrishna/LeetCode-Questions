import java.util.*;

public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    String[] arr = s.split(" ");
    if (arr.length != pattern.length()) {
      return false;
    }
    Map<String, Character> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      char ch = s.charAt(i);
      String str = arr[i];
      if (map.containsKey(str) && map.get(str) != ch) {
        return false;
      } else if (!map.containsKey(str)) {
        map.put(str, ch);
      }
    }
    return true;
  }
}
