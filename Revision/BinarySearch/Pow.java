public class Pow {
  public double myPow(double x, int n) {
    double ans = 1;
    long temp = Math.abs((long) n);
    while (temp > 0) {
      if (temp % 2 != 0) {
        ans = ans * x;
      }
      temp /= 2;
      x *= x;
    }

    return n < 0 ? 1 / ans : ans;
  }
}
