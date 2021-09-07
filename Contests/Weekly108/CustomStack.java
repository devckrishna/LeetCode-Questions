import java.util.*;

public class CustomStack {
  List<Integer> stack;
  int maxSize;

  public CustomStack(int maxSize) {
    stack = new ArrayList<>();
    this.maxSize = maxSize + 1;
  }

  public void push(int x) {
    if (stack.size() < maxSize) {
      stack.add(x);
    }
  }

  public int pop() {
    if (stack.size() == 0) {
      return -1;
    } else {
      return stack.remove(stack.size() - 1);
    }
  }

  public void increment(int k, int val) {
    for (int i = 0; i < stack.size() && i < k; i++) {
      stack.set(i, stack.get(i) + val);
    }
  }
}
