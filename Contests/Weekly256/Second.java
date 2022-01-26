import java.math.BigInteger;
import java.util.*;

public class Second {
  public String kthLargestNumber(String[] nums, int k) {
    BigInteger[] arr = new BigInteger[nums.length];
    for (int i = 0; i < nums.length; i++) {
      arr[i] = new BigInteger(nums[i]);
    }
    Arrays.sort(arr);
    return arr[arr.length - k].toString();
  }
}
