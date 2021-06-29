import java.util.*;

public class TimeMap {
  public class Pair {
    int time;
    String value;

    public Pair(int time, String value) {
      this.time = time;
      this.value = value;
    }
  }

  Map<String, List<Pair>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(new Pair(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) {
      return "";
    }
    return binarySearch(map.get(key), timestamp);
  }

  public String binarySearch(List<Pair> arr, int target) {
    int start = 0;
    int end = arr.size() - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (arr.get(mid).time == target) {
        return arr.get(mid).value;
      } else if (arr.get(mid).time < target) {
        if (arr.get(mid + 1).time > target)
          return arr.get(mid).value;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return arr.get(start).time <= target ? arr.get(start).value : "";
  }
}
