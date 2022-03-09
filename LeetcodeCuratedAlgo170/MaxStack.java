import java.util.*;

public class MaxStack {
  Stack<Integer> stack;
  Stack<Integer> maxStack;

  public MaxStack() {
    stack = new Stack<>();
    maxStack = new Stack<>();
  }

  public void push(int x) {
    int max = maxStack.isEmpty() ? x : maxStack.peek();
    maxStack.push(max > x ? max : x);
    stack.push(x);
  }

  public int pop() {
    maxStack.pop();
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return maxStack.peek();
  }

  public int popMax() {
    int temp = maxStack.peek();
    Stack<Integer> buffer = new Stack<>();
    while (temp != top()) {
      buffer.push(pop());
    }
    pop();
    while (!buffer.isEmpty()) {
      push(buffer.pop());
    }
    return temp;
  }
}
