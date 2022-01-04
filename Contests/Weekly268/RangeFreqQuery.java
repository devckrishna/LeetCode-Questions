import java.util.*;

public class RangeFreqQuery {
  Map<Integer, List<Integer>> map;

  public RangeFreqQuery(int[] arr) {
    map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], new ArrayList<>());
      }
      map.get(arr[i]).add(i);
    }
  }

  public int query(int left, int right, int value) {
    if (!map.containsKey(value)) {
      return 0;
    }
    List<Integer> curr = map.get(value);
    int start = Collections.binarySearch(curr, left);
    int end = Collections.binarySearch(curr, right);
    if (start < 0) {
      start = (start + 1) * (-1);
    }
    if (end < 0) {
      end = (end + 2) * (-1);
    }
    return end - start + 1;
  }
}