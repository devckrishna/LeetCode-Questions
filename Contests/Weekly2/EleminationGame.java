public class EleminationGame {
  public int lastRemaining(int n) {
    int head = 1;
    int step = 1;
    boolean left = true;
    int remainging = n;
    while (remainging > 1) {
      if (left || remainging % 2 == 1) {
        head += step;
      }
      step *= 2;
      remainging /= 2;
      left = !left;
    }
    return head;
  }
}
