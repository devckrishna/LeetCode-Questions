public class Second {
  public int minMoves(int target, int maxDoubles) {
    int ans = 0;
    while (target > 1) {
      if (maxDoubles == 0) {
        ans += target - 1;
        break;
      }
      if (target % 2 == 0 && maxDoubles > 0) {
        target /= 2;
        maxDoubles--;
        ans++;
      } else {
        target--;
        ans++;
      }
    }
    return ans;
  }
}
