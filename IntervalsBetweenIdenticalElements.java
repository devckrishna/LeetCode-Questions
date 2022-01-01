import java.util.*;

public class IntervalsBetweenIdenticalElements {
  public long[] getDistances(int[] arr) {
    long[] ans = new long[arr.length];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.get(arr[i]).add(i);
      } else {
        map.put(arr[i], new ArrayList<>());
        map.get(arr[i]).add(i);
      }
    }

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      List<Integer> list = entry.getValue();
      long sum = 0;
      for (int num : list) {
        sum += (long) num;
      }
      long preSum = 0;
      int size = list.size();
      for (int i = 0; i < size; i++) {
        int num = list.get(i);
        preSum += num;
        ans[num] = sum + (2 * i + 2 - size) * (long) num - 2 * preSum;
      }
    }
    return ans;
  }
}
