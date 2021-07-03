import java.util.Stack;

public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return 0;

    int[] height = new int[matrix[0].length];
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == '1') {
        height[i] = 1;
      }
    }

    int ans = findMaxArea(height);
    for (int i = 1; i < matrix.length; i++) {
      resetHeight(matrix, height, i);
      ans = Math.max(ans, findMaxArea(height));
    }
    return ans;
  }

  public void resetHeight(char[][] matrix, int[] height, int index) {
    for (int i = 0; i < matrix[index].length; i++) {
      if (matrix[index][i] == '1') {
        height[i] += 1;
      } else {
        height[i] = 0;
      }
    }
  }

  public int findMaxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    Stack<Integer> st = new Stack<>();
    int[] left = new int[height.length];
    int[] right = new int[height.length];
    left[0] = -1;
    right[right.length - 1] = height.length;
    st.push(0);
    for (int i = 1; i < left.length; i++) {
      while (!st.isEmpty() && height[i] <= height[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = st.peek();
      }
      st.push(i);
    }

    st = new Stack<>();
    st.push(height.length - 1);
    for (int i = right.length - 2; i >= 0; i--) {
      while (!st.isEmpty() && height[i] <= height[st.peek()]) {
        st.pop();
      }
      if (st.isEmpty()) {
        right[i] = height.length;
      } else {
        right[i] = st.peek();
      }
      st.push(i);
    }

    int ans = 0;
    for (int i = 0; i < height.length; i++) {
      int width = right[i] - left[i] - 1;
      int currArea = height[i] * width;
      if (currArea > ans) {
        ans = currArea;
      }
    }
    return ans;
  }
}
