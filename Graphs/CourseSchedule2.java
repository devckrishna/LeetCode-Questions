import java.util.*;

public class CourseSchedule2 {
  static int white = 0;
  static int grey = 1;
  static int black = 2;
  Map<Integer, Integer> color;
  Map<Integer, List<Integer>> adj;
  List<Integer> topSort;
  boolean isPossible;

  void init(int numCourses) {
    color = new HashMap<>();
    adj = new HashMap<>();
    topSort = new ArrayList<>();
    isPossible = true;
    for (int i = 0; i < numCourses; i++) {
      color.put(i, white);
    }
  }

  void dfs(int src) {
    if (!isPossible) {
      return;
    }
    color.put(src, grey);
    for (Integer nei : adj.getOrDefault(src, new ArrayList<>())) {
      if (color.get(nei) == white) {
        dfs(nei);
      } else if (color.get(nei) == grey) {
        isPossible = false;
        return;
      }
    }
    color.put(src, black);
    topSort.add(src);
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    init(numCourses);

    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adj.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adj.put(src, lst);
    }

    for (int i = 0; i < numCourses; i++) {
      if (color.get(i) == white) {
        dfs(i);
      }
    }
    int[] order;
    if (isPossible) {
      order = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        order[i] = topSort.get(numCourses - i - 1);
      }
    } else {
      order = new int[0];
    }

    return order;
  }
}
