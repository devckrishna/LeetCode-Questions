import java.util.*;

public class LockingTree {
  Map<Integer, List<Integer>> tree;
  Map<Integer, Integer> locked;
  int[] arr;

  public LockingTree(int[] parent) {
    arr = new int[parent.length];
    arr = parent;
    tree = new HashMap<>();
    locked = new HashMap<>();
    for (int i = 1; i < parent.length; i++) {
      if (!tree.containsKey(parent[i])) {
        tree.put(parent[i], new ArrayList<>());
      }
      tree.get(parent[i]).add(i);
    }
  }

  public boolean lock(int num, int user) {
    if (locked.containsKey(num)) {
      return false;
    } else {
      locked.put(num, user);
      return true;
    }
  }

  public boolean unlock(int num, int user) {
    if (locked.get(num) != user) {
      return false;
    }
    locked.remove(num);
    return true;
  }

  public boolean upgrade(int num, int user) {
    if (!locked.containsKey(num) && isParent(num) && isDesc(num)) {
      locked.put(num, user);
      for (int curr : tree.get(num)) {
        locked.remove(curr);
      }
      return true;
    } else {
      return false;
    }
  }

  public boolean isParent(int num) {
    if (arr[num] == -1) {
      return true;
    }
    if (locked.containsKey(num)) {
      return false;
    }
    return isParent(arr[num]);
  }

  public boolean isDesc(int num) {
    if (locked.containsKey(num)) {
      return true;
    }

    for (Integer curr : tree.get(num)) {
      System.out.println(curr);
      boolean ans = isDesc(curr);
      if (ans) {
        return true;
      }
    }
    return false;
  }
}
