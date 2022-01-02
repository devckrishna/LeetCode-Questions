import java.util.*;

public class Third {
  public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    Arrays.sort(asteroids);
    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> high = new PriorityQueue<>();
    int piviot = -1;
    for (int i = 0; i < asteroids.length; i++) {
      if (asteroids[i] > mass) {
        piviot = i;
        break;
      }
    }
    for (int i = 0; i < piviot; i++) {
      low.offer(asteroids[i]);
    }
    for (int i = piviot; i < asteroids.length && i >= 0; i++) {
      high.offer(asteroids[i]);
    }
    long currMass = (long) mass;
    while (low.size() > 0) {
      currMass += low.remove();
    }

    int max = 0;
    for (int curr : asteroids) {
      max = Math.max(max, curr);
    }
    while (high.size() > 0 && high.peek() <= currMass) {
      if (currMass > max) {
        return true;
      }
      currMass += high.remove();
    }
    return low.isEmpty() && high.isEmpty();
  }
}
