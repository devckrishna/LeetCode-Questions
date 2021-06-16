import java.util.*;

public class SplitIntoMaxNumberOfUniqueSubStrings {
  public int maxUniqueSplit(String s) {
    Set<String> set = new HashSet<>();
    return solve(s, 0, set);

  }

  public int solve(String s, int index, Set<String> set) {
    if (index >= s.length()) {
      return 0;
    }
    int res = -1;
    for (int i = index + 1; i <= s.length(); i++) {
      String curr = s.substring(index, i);
      if (!set.add(curr)) {
        continue;
      }
      int recAns = solve(s, i, set);
      if (recAns >= 0) {
        res = Math.max(res, recAns + 1);
      }
      set.remove(curr);
    }
    return res;
  }

}
