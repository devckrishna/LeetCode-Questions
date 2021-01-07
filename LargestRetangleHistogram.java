import java.util.*;

class LargestRectangleHistogram {
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    Stack<Integer> st = new Stack<>();
    st.push(heights.length - 1);
    int[] rb = new int[heights.length];

    rb[heights.length - 1] = heights.length;

    for (int i = heights.length - 2; i >= 0; i--) {
      while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        rb[i] = heights.length;
      } else {
        rb[i] = st.peek();
      }
      st.push(i);
    }

    st = new Stack<>();
    int[] lb = new int[heights.length];
    lb[0] = -1;
    st.push(0);
    for (int i = 1; i < heights.length; i++) {
      while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        lb[i] = -1;
      } else {
        lb[i] = st.peek();
      }
      st.push(i);
    }

    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      int width = rb[i] - lb[i] - 1;
      int currMax = heights[i] * width;
      if (currMax > max) {
        max = currMax;
      }
    }
    return max;
  }
}