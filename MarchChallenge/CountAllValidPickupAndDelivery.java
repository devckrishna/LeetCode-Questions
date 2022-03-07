public class CountAllValidPickupAndDelivery {
  public int countOrders(int n) {
    long res = 1;
    int mod = 1000000007;
    for (int i = 1; i <= n; ++i)
      res = res * (i * 2 - 1) * i % mod;
    return (int) res;
  }
}
