import java.util.*;

public class FrogJump {
  public boolean canCross(int[] stones) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int stone : stones) {
      map.put(stone, new HashSet<>());
    }
    map.get(stones[0]).add(1);
    for (int stone : stones) {
      Set<Integer> jumps = map.get(stone);
      for (int jump : jumps) {
        int postition = stone + jump;
        if (postition == stones[stones.length - 1]) {
          return true;
        }
        if (map.containsKey(postition)) {
          if (jump - 1 > 0)
            map.get(postition).add(jump - 1);
          map.get(postition).add(jump);
          map.get(postition).add(jump + 1);
        }
      }
    }

    return false;
  }
}
