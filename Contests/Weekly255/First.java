import java.util.Arrays;

public class First {
  public int findGCD(int[] nums) {
    Arrays.sort(nums);
    return gcd(nums[0], nums[nums.length - 1]);
  }

  public int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    if (a == b) {
      return a;
    }
    if (a > b) {
      return gcd(a % b, b);
    }
    return gcd(b, a % b);
  }
}