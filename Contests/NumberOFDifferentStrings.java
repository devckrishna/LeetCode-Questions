import java.util.*;

public class NumberOFDifferentStrings {
  public int numDifferentIntegers(String word) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < word.length(); i++) {
      if (Character.isDigit(word.charAt(i))) {
        StringBuilder sb = new StringBuilder();
        while (i < word.length() && word.charAt(i) == '0')
          i++;
        while (i < word.length() && Character.isDigit(word.charAt(i)))
          sb.append(word.charAt(i++));
        if (sb.length() == 0)
          sb.append("0");
        set.add(sb.toString());
      }
    }
    return set.size();
  }
}
