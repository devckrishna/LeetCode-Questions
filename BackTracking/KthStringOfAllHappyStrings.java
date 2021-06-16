import java.util.*;

public class KthStringOfAllHappyStrings {
  List<String> list = new ArrayList<>();

  public String getHappyString(int n, int k) {
    String str = "abc";
    solve(str, n, 0, "");
    return list.size() >= k ? list.get(k - 1) : "";
  }

  private void solve(String str, int len, int index, String cur) {
    if (cur.length() == len) {
      list.add(cur);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      if (cur.length() > 0 && cur.charAt(cur.length() - 1) == str.charAt(i)) {
        continue;
      }
      solve(str, len, 0, cur + str.charAt(i));
    }
  }
}