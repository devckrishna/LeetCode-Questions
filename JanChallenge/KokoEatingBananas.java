public class KokoEatingBananas {
  public boolean solve(int[] piles, int mid, int h) {
    int count = 0;
    for (int pile : piles) {
      count += pile / mid;
      if (pile % mid != 0) {
        count++;
      }
    }
    return count <= h;
  }

  public int minEatingSpeed(int[] piles, int h) {
    int end = 0;
    for (int pile : piles) {
      end = Math.max(end, pile);
    }
    int start = 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (solve(piles, mid, h)) {
        end = mid;
      } else {
        start = mid + 1;
      }

    }
    return start;
  }
}
