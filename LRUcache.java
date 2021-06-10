import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache {
  private LinkedHashMap<Integer, Integer> map;
  private final int CAPACITY;

  public LRUcache(int capacity) {
    CAPACITY = capacity;
    map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > CAPACITY;
      }
    };
  }

  public int get(int key) {
    return map.getOrDefault(key, -1);
  }

  public void set(int key, int value) {
    map.put(key, value);
  }
}

class LRUCache {
  // 14ms,44.90%; 47MB,65.13%
  int capacity;
  int size;
  transient LinkedNode head;
  transient LinkedNode tail;
  Map<Integer, LinkedNode> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    map = new HashMap<>(capacity * 2);
    head = null;
    tail = null;
  }

  public int get(int key) {
    LinkedNode node = remove(key);
    if (node == null) {
      return -1;
    }
    put(key, node.val);
    return node.val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      remove(key);
    } else if (size >= capacity) {
      remove(head.key);
    }
    if (size == 0) {
      head = new LinkedNode(key, value, null, null);
      tail = head;
    } else {
      LinkedNode tmp = tail;
      tail = new LinkedNode(key, value, tail, null);
      tmp.next = tail;
    }
    map.put(key, tail);
    size++;
  }

  private LinkedNode remove(int key) {
    LinkedNode node = map.remove(key);
    if (node == null)
      return node;

    if (size == 1) {
      head = null;
      tail = null;
    } else {
      if (node == head) {
        head = head.next;
      } else if (node == tail) {
        tail = tail.pre;
      }
      LinkedNode pre = node.pre;
      LinkedNode next = node.next;
      if (pre != null)
        pre.next = next;
      if (next != null)
        next.pre = pre;
      node.next = null;
      node.pre = null;
    }
    size--;

    return node;
  }

  private static class LinkedNode {
    int key;
    int val;
    LinkedNode pre;
    LinkedNode next;

    LinkedNode(int key, int val, LinkedNode pre, LinkedNode next) {
      this.key = key;
      this.val = val;
      this.pre = pre;
      this.next = next;
    }
    // public LinkedNode(int key, int val) {
    // this(key, val, null, null);
    // }
  }
}