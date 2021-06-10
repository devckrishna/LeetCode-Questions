import java.util.*;

class QueueRecontructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    List<int[]> ans = new ArrayList<>();
    for (int[] curr : people) {
      ans.add(curr[1], curr);
    }
    return ans.toArray(new int[people.length][2]);
  }
}