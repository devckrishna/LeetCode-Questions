import java.util.*;

public class FreqStack {
  Map<Integer, Integer> freq = new HashMap<>();
  Map<Integer, Stack<Integer>> stacks = new HashMap<>();
  int maxFreq;

  public FreqStack() {
    freq = new HashMap<>();
    stacks = new HashMap<>();
    maxFreq = 0;
  }

  public void push(int val) {
    int currFreq = freq.getOrDefault(val, 0) + 1;
    freq.put(val, currFreq);
    if (currFreq > maxFreq) {
      maxFreq = currFreq;
    }
    stacks.computeIfAbsent(currFreq, f -> new Stack<>()).push(val);
  }

  public int pop() {
    Stack<Integer> st = stacks.get(maxFreq);
    int top = st.pop();
    if (st.isEmpty()) {
      maxFreq--;
    }
    freq.put(top, freq.get(top) - 1);
    return top;
  }
}