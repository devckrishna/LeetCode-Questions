import java.util.*;

public class MeetingRooms2 {
  public int minMeetingRooms(int[][] intervals) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int[] curr : intervals) {
      map.put(curr[0], map.getOrDefault(curr[0], 0) + 1);
      map.put(curr[1], map.getOrDefault(curr[1], 0) - 1);
    }
    int temp = 0;
    int ans = 0;
    for (int curr : map.values()) {
      temp += curr;
      ans = Math.max(ans, temp);
    }
    return ans;
  }
}
