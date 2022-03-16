public class RangeAddition {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] ans = new int[length];
    for (int[] update : updates) {
      int start = update[0];
      int end = update[1];
      int inc = update[2];
      ans[start] += inc;
      if (end < length - 1) {
        ans[end + 1] -= inc;
      }
    }
    for (int i = 1; i < length; i++) {
      ans[i] += ans[i - 1];
    }
    return ans;
  }
}
