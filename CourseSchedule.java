import java.util.*;

public class CourseSchedule {
  public boolean isCyclic(List<List<Integer>> graph, int[] visited, int index) {
    if (visited[index] == 2) {
      return true;
    }
    visited[index] = 2;
    for (int i = 0; i < graph.get(index).size(); i++) {
      int edge = graph.get(index).get(i);
      if (visited[edge] != 1) {
        if (isCyclic(graph, visited, edge)) {
          return true;
        }
      }
    }
    visited[index] = 1;
    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }
    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == 0) {
        if (isCyclic(graph, visited, i)) {
          return false;
        }
      }
    }
    return true;
  }
}
