import java.util.*;

class ValidStackSequence {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> st = new Stack<>();
    int j = 0;
    for (int i = 0; i < pushed.length; i++) {
      st.push(pushed[i]);
      while (!st.isEmpty() && j < pushed.length && st.peek() == popped[j]) {
        st.pop();
        j++;
      }
    }
    return j == pushed.length;
  }
}