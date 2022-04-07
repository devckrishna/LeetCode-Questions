public class First {
  public int minBitFlips(int start, int goal) {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int first = (1 << i) & start;
      int second = (1 << i) & goal;
      if (first != second) {
        ans++;
      }
    }
    return ans;
  }
}