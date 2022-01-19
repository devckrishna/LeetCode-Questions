public class Second {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    int[] ans = new int[n];
    int sum = 0;
    for (int curr : rolls) {
      sum += curr;
    }
    System.out.println(sum);
    int val = (mean * (rolls.length + n)) - sum;
    System.out.println(((val * 1.0) / n));
    if (((val * 1.0) / n) > 6 || ((val * 1.0) / n) < 1) {
      return new int[] {};
    }

    int roll = val / n;
    for (int i = 0; i < ans.length; i++) {
      ans[i] = roll;
      val -= roll;
    }
    int index = 0;
    while (index < ans.length && val > 0) {
      int temp = 6 - ans[index];
      temp = Math.min(temp, val);
      ans[index] += temp;
      val -= temp;
      index++;
    }

    if (val > 0) {
      return new int[] {};
    }

    return ans;
  }
}
