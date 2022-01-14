import java.util.*;

public class Third {
  public int minimumOperations(int[] nums, int start, int goal) {
    Queue<Integer> qu = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int ans = 1;
    qu.add(start);
    while (!qu.isEmpty()) {
      int size = qu.size();
      for (int i = 0; i < size; i++) {
        int val = qu.poll();
        if (val == goal) {
          return ans;
        }
        if (!(val >= 0 && val <= 1000) || set.contains(val)) {
          continue;
        }
        set.add(val);
        for (int num : nums) {
          qu.add(val + num);
          qu.add(val - num);
          qu.add(val ^ num);
        }
      }

      ans++;
    }

    return -1;
  }
}
