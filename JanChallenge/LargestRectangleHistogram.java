import java.util.*;

public class LargestRectangleHistogram {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> st = new Stack<>();
    int n = heights.length;
    int[] right = new int[n];
    int[] left = new int[n];

    right[n - 1] = n;
    st.push(heights.length - 1);
    for (int i = n - 2; i >= 0; i--) {
      while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        right[i] = n;
      } else {
        right[i] = st.peek();
      }
      st.push(i);
    }

    left[0] = -1;
    st = new Stack<>();
    st.push(0);
    for (int i = 1; i < n; i++) {
      while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = st.peek();
      }
      st.push(i);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int width = right[i] - left[i] - 1;
      ans = Math.max(ans, heights[i] * width);
    }

    return ans;
  }
}
