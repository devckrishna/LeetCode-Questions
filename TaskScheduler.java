import java.util.*;

class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    int[] char_map = new int[26];
    for (char c : tasks) {
      char_map[c - 'A']++;
    }
    Arrays.sort(char_map);
    int maxVal = char_map[25] - 1;
    int idle = maxVal * n;

    for (int i = 24; i >= 0; i--) {
      idle -= Math.min(char_map[i], maxVal);
    }
    return idle > 0 ? idle + tasks.length : tasks.length;
  }
}