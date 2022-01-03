import java.util.*;

public class Fourth {
  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    List<Integer> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    qu.offer(new int[] { 0, 0 });
    qu.offer(new int[] { firstPerson, 0 });
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int[] meeting : meetings) {
      map.putIfAbsent(meeting[0], new ArrayList<>());
      map.putIfAbsent(meeting[1], new ArrayList<>());

      map.get(meeting[0]).add(new int[] { meeting[1], meeting[2] });
      map.get(meeting[1]).add(new int[] { meeting[0], meeting[2] });
    }

    while (!qu.isEmpty()) {
      int[] curr = qu.poll();
      if (!visited.contains(curr[0])) {
        visited.add(curr[0]);
        ans.add(curr[0]);
      }
      if (!map.containsKey(curr[0])) {
        continue;
      }
      for (int[] meeting : map.get(curr[0])) {
        if (meeting[1] < curr[1]) {
          continue;
        }
        qu.offer(new int[] { meeting[0], meeting[1] });
      }
      map.remove(curr[0]);
    }

    return ans;
  }
}
