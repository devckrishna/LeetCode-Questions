import java.util.*;

public class FrogJump {
  public boolean canCross(int[] stones) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < stones.length; i++) {
      map.put(stones[i], new HashSet<>());
    }
    map.get(stones[0]).add(1);
    for (int i = 0; i < stones.length; i++) {
      Set<Integer> jumps = map.get(stones[i]);
      for (int jump : jumps) {
        int position = stones[i] + jump;
        if (position == stones[stones.length - 1]) {
          return true;
        }
        if (map.containsKey(position)) {
          if (jump - 1 > 0) {
            map.get(position).add(jump - 1);
          }
          map.get(position).add(jump);
          map.get(position).add(jump + 1);
        }
      }
    }
    return false;
  }
}
