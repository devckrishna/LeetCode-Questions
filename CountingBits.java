class CountingBits {
  public int[] countBits(int num) {
    int[] ans = new int[num + 1];
    int offset = 1;
    for (int i = 1; i < ans.length; i++) {
      if (offset * 2 == i) {
        offset *= 2;
      }
      ans[i] = ans[i - offset] + 1;
    }
    return ans;
  }
}