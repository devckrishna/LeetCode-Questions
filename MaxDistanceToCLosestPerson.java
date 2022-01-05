public class MaxDistanceToCLosestPerson {
  public int maxDistToClosest(int[] seats) {
    int ans = 0;
    int left = -1;
    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == 0) {
        continue;
      }
      if (left == -1) {
        ans = i;
      } else {
        ans = Math.max(ans, (i - left) / 2);
      }
      left = i;
    }

    if (seats[seats.length - 1] == 0) {
      ans = Math.max(ans, seats.length - left - 1);
    }

    return ans;
  }
}
