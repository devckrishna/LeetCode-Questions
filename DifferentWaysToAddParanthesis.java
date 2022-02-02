import java.util.*;

public class DifferentWaysToAddParanthesis {
  Map<String, List<Integer>> map = new HashMap<>();

  public List<Integer> diffWaysToCompute(String expression) {
    if (map.containsKey(expression)) {
      return map.get(expression);
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        String first = expression.substring(0, i);
        String second = expression.substring(i + 1);
        List<Integer> one = diffWaysToCompute(first);
        List<Integer> two = diffWaysToCompute(second);
        for (int curr1 : one) {
          for (int curr2 : two) {
            int temp = 0;
            if (ch == '-') {
              temp = curr1 - curr2;
            } else if (ch == '+') {
              temp = curr1 + curr2;
            } else if (ch == '*') {
              temp = curr1 * curr2;
            }
            ans.add(temp);
          }
        }
      }
    }
    if (ans.size() == 0) {
      ans.add(Integer.valueOf(expression));
    }
    map.put(expression, ans);
    return ans;
  }
}
