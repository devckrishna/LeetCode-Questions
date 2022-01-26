import java.util.*;

public class Third {
  public int minSessions(int[] tasks, int sessionTime) {
    Arrays.sort(tasks);
    int ans = 0;
    int curr = 0;
    int index = 0;
    while (index < tasks.length) {
      if (curr + tasks[index] <= sessionTime) {
        curr += tasks[index];
      } else {
        ans++;
        curr = tasks[index];
      }
      index++;
    }
    if (curr > 0) {
      ans++;
    }
    return ans;
  }
}
