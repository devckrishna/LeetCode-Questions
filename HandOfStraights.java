import java.util.*;

class HandOfStraights {
  public boolean isNStraightHand(int[] hand, int W) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < hand.length; i++) {
      if (map.containsKey(hand[i])) {
        map.replace(hand[i], map.get(hand[i]) + 1);
      } else {
        map.put(hand[i], 1);
      }
    }

    while (map.size() > 0) {
      int first = map.firstKey();
      for (int i = first; i < first + W; i++) {
        if (!map.containsKey(i)) {
          return false;
        }
        int count = map.get(i);
        if (count == 1) {
          map.remove(i);
        } else {
          map.replace(i, map.get(i) - 1);
        }
      }
    }
    return true;
  }
}