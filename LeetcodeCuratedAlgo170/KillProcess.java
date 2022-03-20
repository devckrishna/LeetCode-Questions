import java.util.*;

public class KillProcess {
  public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    HashMap<Integer, Node> map = new HashMap<>();
    for (Integer i : pid) {
      map.put(i, new Node(i));
    }

    for (int i = 0; i < ppid.size(); i++) {
      if (ppid.get(i) != 0) {
        map.get(ppid.get(i)).childs.add(map.get(pid.get(i)));
      }
    }
    List<Integer> res = new ArrayList<>();
    dfs(map.get(kill), res);
    return res;
  }

  public static void dfs(Node node, List<Integer> res) {
    if (node == null)
      return;
    res.add(node.id);
    for (Node n : node.childs) {
      dfs(n, res);
    }
  }

  private static class Node {
    Integer id;
    List<Node> childs;

    public Node(Integer id) {
      this.id = id;
      this.childs = new ArrayList<>();
    }
  }
}
