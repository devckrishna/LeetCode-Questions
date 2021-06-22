import java.util.TreeMap;

public class MyCalendarThree {
  TreeMap<Integer, Integer> map;

  public MyCalendarThree() {
    map = new TreeMap<>();
  }

  public int book(int start, int end) {
    map.put(start, map.getOrDefault(start, 0) + 1);
    map.put(end, map.getOrDefault(end, 0) - 1);

    int temp = 0;
    int ans = 0;
    for (int curr : map.values()) {
      temp += curr;
      ans = Math.max(ans, temp);
    }
    return ans;
  }
}
