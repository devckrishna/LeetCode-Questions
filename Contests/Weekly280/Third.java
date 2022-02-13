import java.util.*;

public class Third {
  public long minimumRemoval(int[] beans) {
    long max = 0;
    long sum = 0;
    Arrays.sort(beans);
    for (int i = 0; i < beans.length; i++) {
      sum += beans[i];
      max = Math.max(max, (long) beans[i] * (beans.length - i));
    }
    return sum - max;
  }
}
