import java.util.*;

public class BuildingsWithAnOceanView {
  public int[] findBuildings(int[] heights) {
    int n = heights.length;
    List<Integer> curr = new ArrayList<>();
    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
        st.pop();
      }
      if (st.isEmpty()) {
        curr.add(i);
      }
      st.push(i);
    }
    int[] ans = new int[curr.size()];
    for (int i = 0; i < curr.size(); ++i) {
      ans[i] = curr.get(curr.size() - 1 - i);
    }

    return ans;
  }
}
