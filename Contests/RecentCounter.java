import java.util.*;

public class RecentCounter {
  List<Integer> arr;

  public RecentCounter() {
    arr = new ArrayList<>();
  }

  public int ping(int t) {
    arr.add(t);
    int count = 0;
    int i = arr.size() - 1;
    int val = t - 3000;
    while (i >= 0 && arr.get(i) >= val) {
      count++;
      i--;
    }
    return count;
  }
}
