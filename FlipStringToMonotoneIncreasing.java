public class FlipStringToMonotoneIncreasing {
  public int minFlipsMonoIncr(String s) {
    int[] left = new int[s.length()];
    int[] right = new int[s.length()];
    left[0] = s.charAt(0) == '1' ? 1 : 0;
    for (int i = 1; i < left.length; i++) {
      if (s.charAt(i) == '1') {
        left[i] = 1 + left[i - 1];
      } else {
        left[i] = left[i - 1];
      }
    }
    right[right.length - 1] = s.charAt(right.length - 1) == '0' ? 1 : 0;
    for (int i = right.length - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        right[i] = 1 + right[i + 1];
      } else {
        right[i] = right[i + 1];
      }
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      ans = Math.min(ans, left[i] + right[i] - 1);
    }
    return ans;
  }
}
