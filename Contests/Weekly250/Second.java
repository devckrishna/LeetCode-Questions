public class Second {
  public int addRungs(int[] rungs, int dist) {
    int pos = 0;
    int ans = 0;
    for (int rung : rungs) {
      if (rung - pos > dist) {
        ans += (rung - pos - 1) / (dist);
      }
      pos = rung;
    }
    return ans;
  }
}
