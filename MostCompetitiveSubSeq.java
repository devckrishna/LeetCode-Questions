import java.util.*;

public class MostCompetitiveSubSeq {
  public int[] mostCompetitive(int[] nums, int k) {
    int[] ans = new int[k];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
      while (!st.isEmpty() && nums[i] < nums[st.peek()] && nums.length - i + st.size() > k) {
        st.pop();
      }
      if (st.size() < k) {
        st.push(i);
      }
    }
    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = nums[st.pop()];
    }
    return ans;
  }
}
