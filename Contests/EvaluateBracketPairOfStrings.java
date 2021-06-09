import java.util.*;

public class EvaluateBracketPairOfStrings {
  public String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> map = new HashMap<>();
    for (List<String> arr : knowledge) {
      map.put(arr.get(0), arr.get(1));
    }
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      char ch = s.charAt(i);
      if (ch == '(') {
        i++;
        String curr = "";
        while (i < s.length() && s.charAt(i) != ')') {
          curr += s.charAt(i);
          i++;
        }
        i++;
        if (map.containsKey(curr)) {
          sb.append(map.get(curr));
        } else {
          sb.append("?");
        }
      } else {
        sb.append(ch);
        i++;
      }
    }
    return sb.toString();
  }
}
