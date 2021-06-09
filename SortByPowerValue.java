import java.util.*;

class SortByPowerValue {
  class Pair {
    int num;
    int pow;

    public Pair(int num, int pow) {
      this.num = num;
      this.pow = pow;
    }
  }

  public int getKth(int lo, int hi, int k) {
    List<Pair> arr = new ArrayList<>();
    while (lo <= hi) {
      int count = 0;
      int val = lo;
      while (val != 1) {
        if (val % 2 == 0) {
          val = val / 2;
        } else {
          val = 3 * val + 1;
        }
        count++;
      }
      arr.add(new Pair(lo, count));
      lo++;
    }
    Collections.sort(arr, (a, b) -> a.pow - b.pow);
    return arr.get(k).num;
  }
}