import java.util.ArrayList;

public class SplittingTheStringIntoDecsendingValues {
  public boolean splitString(String s) {
    return solve(s, 0, new ArrayList<>());
  }

  public boolean solve(String s, int pos, ArrayList<Long> list) {
    if (pos >= s.length()) {
      return list.size() >= 2;
    }
    long num = 0;
    for (int i = pos; i < s.length(); i++) {
      num = num * 10 + (int) (s.charAt(i) - '0');
      if (list.size() == 0 || list.get(list.size() - 1) - num == 1) {
        list.add(num);
        if (solve(s, i + 1, list)) {
          return true;
        }
        list.remove(list.size() - 1);
      }
    }
    return false;
  }
}
