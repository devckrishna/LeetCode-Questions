import java.util.*;

public class RecognizeString {
  public String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      if (map.get(ch) > ((s.length() + 1) / 2)) {
        return "";
      }
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (char c : map.keySet()) {
      pq.add(new int[] { c, map.get(c) });
    }
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      int[] first = pq.poll();
      if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
        sb.append((char) first[0]);
        if (--first[1] > 0) {
          pq.offer(first);
        }
      } else {
        int[] second = pq.poll();
        sb.append((char) second[0]);
        if (--second[1] > 0) {
          pq.offer(second);
        }
        pq.offer(first);
      }
    }

    return sb.toString();
  }
}
