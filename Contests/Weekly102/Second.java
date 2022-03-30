import java.util.*;

public class Second {
  public int totalFruit(int[] arr) {
    if (arr.length == 1) {
      return 1;
    }
    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int i = 0;
    int j = 1;
    map.put(arr[i], 1);
    while (j < arr.length) {
      map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
      while (map.size() > 2) {
        if (map.get(arr[i]) == 1) {
          map.remove(arr[i]);
        } else {
          map.put(arr[i], map.get(arr[i]) - 1);
        }
        i++;
      }
      ans = Math.max(ans, j - i + 1);
      j++;
    }
    return ans;
  }
}
