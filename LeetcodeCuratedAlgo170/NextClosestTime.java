import java.util.*;

public class NextClosestTime {
  int diff = Integer.MAX_VALUE;
  String result = "";

  public String nextClosestTime(String time) {
    Set<Integer> set = new HashSet<>();
    set.add(Integer.parseInt(time.substring(0, 1)));
    set.add(Integer.parseInt(time.substring(1, 2)));
    set.add(Integer.parseInt(time.substring(3, 4)));
    set.add(Integer.parseInt(time.substring(4, 5)));

    if (set.size() == 1)
      return time;

    List<Integer> arr = new ArrayList<>(set);
    int currTime = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));

    dfs(arr, "", 0, currTime);

    return result;
  }

  private void dfs(List<Integer> digits, String cur, int index, int target) {
    if (index == 4) {
      int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
      if (m == target)
        return;
      int d = m - target > 0 ? m - target : 2400 + m - target;
      if (d < diff) {
        diff = d;
        result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
      }
      return;
    }

    for (int i = 0; i < digits.size(); i++) {
      if (index == 0 && digits.get(i) > 2)
        continue;
      if (index == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23)
        continue;
      if (index == 2 && digits.get(i) > 5)
        continue;
      if (index == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59)
        continue;
      dfs(digits, cur + digits.get(i), index + 1, target);
    }
  }
}
