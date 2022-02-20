public class First {
  public int countEven(int num) {
    int ans = 0;
    for (int i = 1; i <= num; i++) {
      if (solve(i)) {
        ans++;
      }
    }
    return ans;
  }

  public boolean solve(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum % 2 == 0;
  }
}