public class GRumpyOwner {
  public int maxSatisfied(int[] customers, int[] grumpy, int x) {
    int res = 0, max = 0;

    for (int i = 0, extra = 0; i < grumpy.length; i++) {
      if (grumpy[i] == 0)
        res += customers[i];

      if (grumpy[i] == 1)
        extra += customers[i];

      if (i >= x && grumpy[i - x] == 1)
        extra -= customers[i - x];

      max = Math.max(max, extra);
    }
    return res + max;
  }
}
