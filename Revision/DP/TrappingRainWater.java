public class TrappingRainWater {
  public int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }

    int[] left = new int[height.length];
    int[] right = new int[height.length];
    int ans = 0;
    left[0] = height[0];
    right[right.length - 1] = height[height.length - 1];
    for (int i = 1; i < left.length; i++) {
      left[i] = Math.max(left[i - 1], height[i]);
    }

    for (int i = right.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], height[i]);
    }

    for (int i = 1; i < height.length - 1; i++) {
      ans += Math.min(left[i], right[i]) - height[i];
    }

    return ans;
  }
}
